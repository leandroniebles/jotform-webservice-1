package com.jotform.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jotform.api.JotForm;

@Controller
public class Results {
	
	public static final String USER_API_KEY = "c049ac7b9277355b9b5af19a2e9fd471";
	//public static final String USER_API_KEY = "0dde921e4cca562fcf19c9e2a93f5ab9";
	public static final String FORM_ID = "61205668313654";
	
	public static final String MOST_USED_FOR_WORK_ID = "31";
	public static final String MOST_INTERESTING_ID = "32";
	public static final String MOST_FAVORITE_ID = "9";
	public static final String KNOWLEDGE_ON_MOST_FAVORITE_ID = "23";
	public static final String LESS_FAVORITE_ID = "33";
	
	@RequestMapping("/results")
	public @ResponseBody String results(){		
		/*
		String response = "{"
			    + "\"responseCode\": 200,"
			    + "\"resultSet\": {"
			    +   "\"offset\": 0,"
			    +    "\"limit\": 100,"
			    +    "\"orderby\": \"id\","
			    +    "\"count\": 1"
			    + "},"
			    + "\"message\": \"success\","
			    + "\"content\": ["
			    +    "{"
			    +        "\"id\": \"337854025291696230\","
			    +        "\"form_id\": \"61205668313654\","
			    +        "\"ip\": \"190.67.136.192\","
			    +        "\"created_at\": \"2016-04-30 15:33:45\","
			    +        "\"status\": \"ACTIVE\","
			    +        "\"new\": \"0\","
			    +        "\"flag\": \"0\","
			    +        "\"updated_at\": \"2016-04-30 15:38:14\","
			    +        "\"answers\": {"
			    +            "\"4\": {"
			    +                "\"text\": \"Nombre\","
			    +                "\"type\": \"control_fullname\","
			    +                "\"answer\": {"
			    +                    "\"first\": \"Leandro Alejandro\","
			    +                    "\"last\": \"Niebles Carbonó\""
			    +                "},"
			    +                "\"prettyFormat\": \"Leandro Alejandro Niebles Carbonó\""
			    +            "},"
			    +            "\"5\": {"
			    +                "\"text\": \"E-mail\","
			    +                "\"type\": \"control_email\","
			    +                "\"answer\": \"leandroniebles@gmail.com\""
			    +            "},"
			    +            "\"6\": {"
			    +                "\"text\": \"Número de teléfono\","
			    +                "\"type\": \"control_phone\","
			    +                "\"answer\": {"
			    +                    "\"area\": \"\","
			    +                    "\"phone\": \"3166965449\""
			    +                "},"
			    +                "\"prettyFormat\": \"() 3166965449\""
			    +            "},"
			    +            "\"9\": {"
			    +                "\"text\": \"¿Cuál es tu lenguaje de programación favorito?\","
			    +                "\"type\": \"control_dropdown\","
			    +                "\"answer\": \"Java\""
			    +            "},"
			    +            "\"23\": {"
			    +                "\"text\": \"¿Cuál es tu conocimiento en este lenguaje?\","
			    +                "\"type\": \"control_scale\","
			    +                "\"answer\": \"7\""
			    +            "},"
			    +            "\"31\": {"
			    +                "\"text\": \"¿En cuáles de estos lenguajes ha desarrollado usted al menos una vez en su vida?\","
			    +                "\"type\": \"control_checkbox\","
			    +                "\"answer\": ["
			    +                    "\"C/C++\","
			    +                    "\"Java\","
			    +                    "\"PHP\","
			    +                    "\"Matlab\","
			    +                    "\"Visual Basic\""
			    +                "],"
			    +                "\"prettyFormat\": \"C/C++; Java; PHP; Matlab; Visual Basic\""
			    +            "},"
			    +            "\"32\": {"
			    +                "\"text\": \"¿En cuáles de estos lenguajes está usted interesado en desarrollar o en aprender a desarrollar?\","
			    +                "\"type\": \"control_checkbox\","
			    +                "\"answer\": ["
			    +                    "\"Java\","
			    +                    "\"Python\","
			    +                    "\"Ruby\""
			    +                "],"
			    +                "\"prettyFormat\": \"Java; Python; Ruby\""
			    +            "},"
			    +            "\"33\": {"
			    +                "\"text\": \"¿Cuál es tu lenguaje de programación menos favorito?\","
			    +                "\"type\": \"control_dropdown\","
			    +                "\"answer\": \"C\""
			    +            "}"
			    +        "}"
			    +    "}"
			    + "],"
			    +"\"limit-left\": 999,"
			    +"\"duration\": \"49ms\""
			+ "}";
		*/
		JotForm client = new JotForm(USER_API_KEY);
		//JSONObject userInfo = client.getUser();
		JSONObject submissions = client.getSubmissions();
		//JSONObject submissions = new JSONObject(response);
		String output = "";
		int responseCode = submissions.getInt("responseCode");
		int totalSubmissions = submissions.getJSONObject("resultSet").getInt("count");
		int remainingRequests = submissions.getInt("limit-left");
		String requestDuration = submissions.getString("duration");
		
		Summary summary = new Summary();
		
		JSONArray content = submissions.getJSONArray("content");
		// Buscar en todos los formularios enviados
		for (int i=0; i<content.length(); i++){
			JSONObject formData = content.getJSONObject(i);
			// Verificar la id del formulario
			String formId = formData.getString("form_id");
			// Si el ID del formulario enviado corresponde al del test dado.
			if (formId.compareTo(Results.FORM_ID) == 0){
				JSONObject answers = formData.getJSONObject("answers");
				
				String mostFavorite = answers.getJSONObject(Results.
						MOST_FAVORITE_ID).getString("answer");
				summary.getMostFavorite().put(mostFavorite, 
						summary.getMostFavorite().get(mostFavorite) + 1);
				
				String knowlegeOnMostFavorite = answers.getJSONObject(Results.
						KNOWLEDGE_ON_MOST_FAVORITE_ID).getString("answer");
				summary.getAverageKnowledgeOnMostFavorite().put(mostFavorite, 
						summary.getAverageKnowledgeOnMostFavorite()
						.get(mostFavorite) + Integer.parseInt(knowlegeOnMostFavorite));
				
				String lessFavorite = answers.getJSONObject(Results.
						LESS_FAVORITE_ID).getString("answer");
				summary.getLessFavorite().put(lessFavorite, 
						summary.getLessFavorite().get(lessFavorite) + 1);
				
				JSONArray mostUsedForWork = answers.getJSONObject(Results.
						MOST_USED_FOR_WORK_ID).getJSONArray("answer");
				for (int j=0; j<mostUsedForWork.length(); j++){
					String mostUsed = mostUsedForWork.getString(j);
					summary.getMostUsedForWork().put(mostUsed, 
							summary.getMostUsedForWork().get(mostUsed) + 1);
				}
				
				JSONArray mostInterestingOnes = answers.getJSONObject(Results.
						MOST_INTERESTING_ID).getJSONArray("answer");
				for (int j=0; j<mostInterestingOnes.length(); j++){
					String mostInteresting = mostInterestingOnes.getString(j);
					summary.getMostInteresting().put(mostInteresting, 
							summary.getMostInteresting().get(mostInteresting) + 1);
				}
			}
		}	
		for (String key : summary.getAverageKnowledgeOnMostFavorite().keySet()){
			if (summary.getMostFavorite().get(key) > 0){
				summary.getAverageKnowledgeOnMostFavorite().put(key, 
						summary.getAverageKnowledgeOnMostFavorite().get(key) / 
						summary.getMostFavorite().get(key));
			}			
		}
		
		
		output = "<h1>Resultados de preferencia de lenguajes de programaci&oacuten</h1>"
			+"<br>C&oacutedigo de respuesta: " + responseCode
			+"<br>Env&iacuteos realizados: " + totalSubmissions
			
			+"<h2>Lenguajes m&aacutes usados</h2>"
			+"<table>";
			for (String key: summary.getMostUsedForWork().keySet()){
				output += "<tr><td>" + key + "</td><td>" 
					+ summary.getMostUsedForWork().get(key) + "</td></tr>";
			}
		output += "</table>";
		output += "<h2>Lenguajes de mayor inter&eacutes</h2>"
			+"<table>";
			for (String key: summary.getMostInteresting().keySet()){
				output += "<tr><td>" + key + "</td><td>" 
					+ summary.getMostInteresting().get(key) + "</td></tr>";
			}
		output += "</table>";
		output += "<h2>Lenguajes favoritos</h2>"
			+"<table>";
			for (String key: summary.getMostFavorite().keySet()){
				output += "<tr><td>" + key + "</td><td>" 
					+ summary.getMostFavorite().get(key) + "</td></tr>";
			}
		output += "</table>";
		output += "<h2>Lenguajes de menor inter&eacutes</h2>"
			+"<table>";
			for (String key: summary.getLessFavorite().keySet()){
				output += "<tr><td>" + key + "</td><td>" 
					+ summary.getLessFavorite().get(key) + "</td></tr>";
			}
		output += "</table>";
		output+= "<br>N&uacutemero de peticiones restantes en el d&iacutea: " + remainingRequests
				+"<br>Tiempo de respuesta de la petición: " + requestDuration;
		//return submissions.toString() + "<br>" + output;
		return output;
		
	}
	
	
}
