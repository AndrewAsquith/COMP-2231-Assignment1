/**
 * COMP-2231 Assignment 1 package
 * @author Andrew Asquith
 */
package com.andrewasquith.comp2231.assignment1;

//import the Arrays class for copyOf
import java.util.Arrays;

/**
 * 
 * Class for aggregating numerous SortAlgorithmProfile objects
 * Records the name of the sort and the problem size 
 * The collection of SortAlgorithmProfile objects is used to
 * determine the average duration and number of comparisons
 * of a particular algorithm over the same run.
 * Caller must take care to only add results from the same algorithm
 * as the SortAlgorithmProfile class is agnostic
 *
 */
public class AggregateSortAlgorithmProfile {
	
	/**
	 * Friendly name provided for the sort algorithm
	 */
	private String nameOfSort;

	/**
	 * Description of the type of problem (e.g. ordered, random, etc)
	 */
	private String descriptionOfProblem;
	
	/**
	 * The problem set size being sorted
	 */
	private int sizeOfProblem;
	
	/**
	 * The number of iterations recorded 
	 */
	private int iterations;
	
	/**
	 * Array of SortAlgorithmProfiles from which the average duration
	 * and number of comparisons are computed
	 */
	private SortAlgorithmProfile[] profiles;
	
	/**
	 * Public constructor accepting name, description and problem size
	 * @param sortName A friendly name of the algorithm
	 * @param problemDescription A description of the problem such as random, ordered, etc.
	 * @param problemSize The size of the set being sorted
	 */
	public AggregateSortAlgorithmProfile(String sortName, String problemDescription, int problemSize)
	{
	
		nameOfSort = sortName;
		descriptionOfProblem = problemDescription;
		sizeOfProblem = problemSize;
		
		//start at 0 iterations
		iterations = 0;
		
		//initialize the array to 10 initially, will automatically double in size if necessary
		profiles = new SortAlgorithmProfile[10];
		
	}
	
	
	/**
	 * Add a new SortAlgorithmProfile to the result set
	 * @param profile The profile to add
	 */
	public void addResult(SortAlgorithmProfile profile) {
		
		//if the internal array is full, expand it's size
		if (iterations == profiles.length) {
			expandProfileArray();
		}
		
		//add the profile to the next spot in the array
		profiles[iterations] = profile;
		
		//and then increase the iteration count
		iterations++;
	}
	
	//helper method to double the size of the array 
	private void expandProfileArray() {
		
		//use the built in Arrays.copyOf instead of writing our own
		profiles = Arrays.copyOf(profiles, iterations*2);
		
	}


	/**
	 * Getter to return the current number of iterations recorded
	 * @return the number of iterations recorded
	 */
	public int getNumberOfIterations() {
		return iterations;
	}
	
	/**
	 * Getter for the provided name of the sort
	 * @return the name given to this sort
	 */
	public String getSortName() {
		return nameOfSort;
	}
	
	/**
	 * Getter for the provided problem size
	 * @return the problem set size
	 */
	public int getProblemSize() {
		return sizeOfProblem;
	}
	
	/**
	 * Getter for the description given to the problem set
	 * @return description
	 */
	public String getProblemDescription() {
		return descriptionOfProblem;
	}
	
	
	/**
	 * Determines and returns the average Duration in Milliseconds 
	 * across all recorded profiles
	 * @return the average duration in milliseconds
	 */
	public double getAverageDurationMilliseconds() {
		
		//use longs instead of ints for the bigger range of values
		long durationTotal = 0;
		
		//iterate through the profiles recorded
		for (int i =0; i<iterations; i++) {
			//add the total duration milliseconds to the total
			durationTotal += profiles[i].getDuration().toMillis();
		}
		
		//and return the total duration divided by the iteration count
		return (double)durationTotal / (double)iterations;
	}
	
	/**
	 * Determines and returns the average number of comparisons
	 * across all recorded profiles
	 * @return the average number of comparisons
	 */
	public double getAverageNumberOfComparisons() {
		
		//use longs instead of ints for the bigger range of values
		long comparisonTotal = 0;
		
		//iterate through the profiles recorded
		for (int i =0; i<iterations; i++) {
			//add the number of comparisons to the total number
			comparisonTotal += profiles[i].getNumberOfComparisons();
		}
		
		//and return the total number divided by the iteration count
		return (double)comparisonTotal / (double)iterations;
	}
	
	/**
	 * Friendly string representation of the data
	 * @return a string containing the name, problem description and average values
	 */
	public String toString() {
		return "Sort Name: " + nameOfSort + System.lineSeparator() +
				"Problem Size: " + sizeOfProblem + System.lineSeparator() +
				"Problem Description: " + descriptionOfProblem + System.lineSeparator() +
				"Number of Iterations: " + iterations + System.lineSeparator() +
				"Average Duration (Milliseconds): " + getAverageDurationMilliseconds() + System.lineSeparator() +
				"Average Number of Comparisons: " + getAverageNumberOfComparisons() + System.lineSeparator();
	}
}