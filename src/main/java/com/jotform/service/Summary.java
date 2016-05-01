package com.jotform.service;

import java.util.HashMap;

public class Summary {
	
	private HashMap<String,Integer> mostUsedForWork; 
	private HashMap<String,Integer> mostInteresting;
	private HashMap<String,Integer> mostFavorite;
	private HashMap<String,Integer> averageKnowledgeOnMostFavorite;
	private HashMap<String,Integer> lessFavorite;
	
	public Summary(){
		mostUsedForWork = new HashMap<>();
		mostUsedForWork.put("C/C++", 0);
		mostUsedForWork.put("C#", 0);
		mostUsedForWork.put("Java", 0);
		mostUsedForWork.put("PHP", 0);
		mostUsedForWork.put("Python", 0);
		mostUsedForWork.put("Perl", 0);
		mostUsedForWork.put("Ruby", 0);
		mostUsedForWork.put("Objective-C", 0);
		mostUsedForWork.put("Shell", 0);
		mostUsedForWork.put("R", 0);
		mostUsedForWork.put("Scala", 0);
		mostUsedForWork.put("Go", 0);
		mostUsedForWork.put("Haskell", 0);
		mostUsedForWork.put("Matlab", 0);
		mostUsedForWork.put("Swift", 0);
		mostUsedForWork.put("Clojure", 0);
		mostUsedForWork.put("Groovy", 0);
		mostUsedForWork.put("Visual Basic", 0);
		mostUsedForWork.put("Fortran", 0);
		mostUsedForWork.put("Processing", 0);
		
		mostInteresting = new HashMap<>();
		mostInteresting.put("C/C++", 0);
		mostInteresting.put("C#", 0);
		mostInteresting.put("Java", 0);
		mostInteresting.put("PHP", 0);
		mostInteresting.put("Python", 0);
		mostInteresting.put("Perl", 0);
		mostInteresting.put("Ruby", 0);
		mostInteresting.put("Objective-C", 0);
		mostInteresting.put("Shell", 0);
		mostInteresting.put("R", 0);
		mostInteresting.put("Scala", 0);
		mostInteresting.put("Go", 0);
		mostInteresting.put("Haskell", 0);
		mostInteresting.put("Matlab", 0);
		mostInteresting.put("Swift", 0);
		mostInteresting.put("Clojure", 0);
		mostInteresting.put("Groovy", 0);
		mostInteresting.put("Visual Basic", 0);
		mostInteresting.put("Fortran", 0);
		mostInteresting.put("Processing", 0);
		
		mostFavorite = new HashMap<>();
		mostFavorite.put("C", 0);
		mostFavorite.put("C++", 0);
		mostFavorite.put("C#", 0);
		mostFavorite.put("Java", 0);
		mostFavorite.put("PHP", 0);
		mostFavorite.put("Python", 0);
		mostFavorite.put("Perl", 0);
		mostFavorite.put("Ruby", 0);
		mostFavorite.put("Objective-C", 0);
		mostFavorite.put("Shell", 0);
		mostFavorite.put("R", 0);
		mostFavorite.put("Scala", 0);
		mostFavorite.put("Go", 0);
		mostFavorite.put("Haskell", 0);
		mostFavorite.put("Matlab", 0);
		mostFavorite.put("Swift", 0);
		mostFavorite.put("Clojure", 0);
		mostFavorite.put("Groovy", 0);
		mostFavorite.put("Visual Basic", 0);
		mostFavorite.put("Fortran", 0);
		mostFavorite.put("Processing", 0);
		
		averageKnowledgeOnMostFavorite = new HashMap<>();
		averageKnowledgeOnMostFavorite.put("C", 0);
		averageKnowledgeOnMostFavorite.put("C++", 0);
		averageKnowledgeOnMostFavorite.put("C#", 0);
		averageKnowledgeOnMostFavorite.put("Java", 0);
		averageKnowledgeOnMostFavorite.put("PHP", 0);
		averageKnowledgeOnMostFavorite.put("Python", 0);
		averageKnowledgeOnMostFavorite.put("Perl", 0);
		averageKnowledgeOnMostFavorite.put("Ruby", 0);
		averageKnowledgeOnMostFavorite.put("Objective-C", 0);
		averageKnowledgeOnMostFavorite.put("Shell", 0);
		averageKnowledgeOnMostFavorite.put("R", 0);
		averageKnowledgeOnMostFavorite.put("Scala", 0);
		averageKnowledgeOnMostFavorite.put("Go", 0);
		averageKnowledgeOnMostFavorite.put("Haskell", 0);
		averageKnowledgeOnMostFavorite.put("Matlab", 0);
		averageKnowledgeOnMostFavorite.put("Swift", 0);
		averageKnowledgeOnMostFavorite.put("Clojure", 0);
		averageKnowledgeOnMostFavorite.put("Groovy", 0);
		averageKnowledgeOnMostFavorite.put("Visual Basic", 0);
		averageKnowledgeOnMostFavorite.put("Fortran", 0);
		averageKnowledgeOnMostFavorite.put("Processing", 0);
		
		lessFavorite = new HashMap<>();
		lessFavorite.put("C", 0);
		lessFavorite.put("C++", 0);
		lessFavorite.put("C#", 0);
		lessFavorite.put("Java", 0);
		lessFavorite.put("PHP", 0);
		lessFavorite.put("Python", 0);
		lessFavorite.put("Perl", 0);
		lessFavorite.put("Ruby", 0);
		lessFavorite.put("Objective-C", 0);
		lessFavorite.put("Shell", 0);
		lessFavorite.put("R", 0);
		lessFavorite.put("Scala", 0);
		lessFavorite.put("Go", 0);
		lessFavorite.put("Haskell", 0);
		lessFavorite.put("Matlab", 0);
		lessFavorite.put("Swift", 0);
		lessFavorite.put("Clojure", 0);
		lessFavorite.put("Groovy", 0);
		lessFavorite.put("Visual Basic", 0);
		lessFavorite.put("Fortran", 0);
		lessFavorite.put("Processing", 0);	
	}

	public HashMap<String, Integer> getMostUsedForWork() {
		return mostUsedForWork;
	}

	public void setMostUsedForWork(HashMap<String, Integer> mostUsedForWork) {
		this.mostUsedForWork = mostUsedForWork;
	}

	public HashMap<String, Integer> getMostInteresting() {
		return mostInteresting;
	}

	public void setMostInteresting(HashMap<String, Integer> mostInteresting) {
		this.mostInteresting = mostInteresting;
	}

	public HashMap<String, Integer> getMostFavorite() {
		return mostFavorite;
	}

	public void setMostFavorite(HashMap<String, Integer> mostFavorite) {
		this.mostFavorite = mostFavorite;
	}

	public HashMap<String, Integer> getAverageKnowledgeOnMostFavorite() {
		return averageKnowledgeOnMostFavorite;
	}

	public void setAverageKnowledgeOnMostFavorite(HashMap<String, Integer> averageKnowledgeOnMostFavorite) {
		this.averageKnowledgeOnMostFavorite = averageKnowledgeOnMostFavorite;
	}

	public HashMap<String, Integer> getLessFavorite() {
		return lessFavorite;
	}

	public void setLessFavorite(HashMap<String, Integer> lessFavorite) {
		this.lessFavorite = lessFavorite;
	}
	
	
	
}
