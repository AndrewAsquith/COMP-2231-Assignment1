package com.andrewasquith.comp2231.assignment1;

import java.util.Arrays;

public class AggregateSortAlgorithmProfile {
	
	private String nameOfSort;

	private String descriptionOfProblem;
	
	private int sizeOfProblem;
	
	private int iterations;
	
	private SortAlgorithmProfile[] profiles;
	
	public AggregateSortAlgorithmProfile(String sortName, String problemDescription, int problemSize)
	{
	
		nameOfSort = sortName;
		descriptionOfProblem = problemDescription;
		sizeOfProblem = problemSize;
		iterations = 0;
		
		profiles = new SortAlgorithmProfile[10];
		
	}
	
	
	public void addResult(SortAlgorithmProfile profile) {
		
		if (iterations == profiles.length) {
			expandProfileArray();
		}
		
		profiles[iterations] = profile;
		iterations++;
	}
	
	private void expandProfileArray() {
		profiles = Arrays.copyOf(profiles, iterations*2);
		
	}


	public int getNumberOfIterations() {
		return iterations;
	}
	
	public double getAverageDurationMilliseconds() {
		
		long durationTotal = 0;
		
		for (int i =0; i<iterations; i++) {
			durationTotal += profiles[i].getDuration().toMillis();
		}
		
		return (double)durationTotal / (double)iterations;
		
	}
	
	public double getAverageNumberOfComparisons() {
		
		long comparisonTotal = 0;
		
		for (int i =0; i<iterations; i++) {
			comparisonTotal += profiles[i].getNumberOfComparisons();
		}
		
		return (double)comparisonTotal / (double)iterations;
		
	}
	
	public String toString() {
		return "Sort Name: " + nameOfSort + System.lineSeparator() +
				"Problem Size: " + sizeOfProblem + System.lineSeparator() +
				"Problem Description: " + descriptionOfProblem + System.lineSeparator() +
				"Number of Iterations: " + iterations + System.lineSeparator() +
				"Average Duration (Milliseconds): " + getAverageDurationMilliseconds() + System.lineSeparator() +
				"Average Number of Comparisons: " + getAverageNumberOfComparisons() + System.lineSeparator();
				
	}


	public String getSortName() {
		return nameOfSort;
	}
	
	public int getProblemSize() {
		return sizeOfProblem;
	}
	
	public String getProblemDescription() {
		return descriptionOfProblem;
	}
	

	
	
}
