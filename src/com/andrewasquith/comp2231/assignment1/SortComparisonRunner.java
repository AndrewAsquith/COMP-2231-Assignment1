/**
 * COMP-2231 Assignment 1 package
 * @author Andrew Asquith
 */
package com.andrewasquith.comp2231.assignment1;

//import the filewriter and required exception to create the csv
import java.io.FileWriter;
import java.io.IOException;

//import the Java8 java.time duration and instant classes
import java.time.Duration;
import java.time.Instant;

//import the random number generator
import java.util.Random;

/**
 * Creates several different problem sets for numerous different 
 * sort algorithms and ultimately generates a CSV of the results
 * using the AggregateSortAlgorithmProfile class
 *
 */
public class SortComparisonRunner {

	public static void main(String[] args) {


		// the number of iterations each algorithm and problem set combination should have run
		final int numberOfIterations = 10;
		// the base value for the problem size
		final int problemSizeBase = 10;
		// the number of iterations and on each instance the exponent to generate problem sizes
		final int problemSizeExponent = 4;

		//AggregateSortAlgorithmProfile Arrays to hold the various results
		//we're only exercising 3 different problem "types" - random, ordered and reverse ordered
		AggregateSortAlgorithmProfile[][] selectionResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] insertionResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] bubbleResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] betterBubbleResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] quickResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] mergeResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		
	
		// for each of the exponents 
		for (int i = 0; i < problemSizeExponent; i++) {

			//generate the problem size of base raised to exponent
			int problemSize = (int)Math.pow(problemSizeBase, i+1);
			
			//generate the AggregateSortAlgorithmProfile objects with the descriptions of what they will contain
			selectionResults[0][i] = new AggregateSortAlgorithmProfile("Selection Sort", "Random Array", problemSize);
			insertionResults[0][i] = new AggregateSortAlgorithmProfile("Insertion Sort", "Random Array", problemSize);
			bubbleResults[0][i] = new AggregateSortAlgorithmProfile("Bubble Sort", "Random Array", problemSize);
			betterBubbleResults[0][i] = new AggregateSortAlgorithmProfile("Better Bubble Sort", "Random Array", problemSize);
			quickResults[0][i] = new AggregateSortAlgorithmProfile("Quick Sort", "Random Array", problemSize);
			mergeResults[0][i] = new AggregateSortAlgorithmProfile("Merge Sort", "Random Array", problemSize);
			
			selectionResults[1][i] = new AggregateSortAlgorithmProfile("Selection Sort", "Ordered Array", problemSize);
			insertionResults[1][i] = new AggregateSortAlgorithmProfile("Insertion Sort", "Ordered Array", problemSize);
			bubbleResults[1][i] = new AggregateSortAlgorithmProfile("Bubble Sort", "Ordered Array", problemSize);
			betterBubbleResults[1][i] = new AggregateSortAlgorithmProfile("Better Bubble Sort", "Ordered Array", problemSize);
			quickResults[1][i] = new AggregateSortAlgorithmProfile("Quick Sort", "Ordered Array", problemSize);
			mergeResults[1][i] = new AggregateSortAlgorithmProfile("Merge Sort", "Ordered Array", problemSize);
			
			selectionResults[2][i] = new AggregateSortAlgorithmProfile("Selection Sort", "Reverse Ordered Array", problemSize);
			insertionResults[2][i] = new AggregateSortAlgorithmProfile("Insertion Sort", "Reverse Ordered Array", problemSize);
			bubbleResults[2][i] = new AggregateSortAlgorithmProfile("Bubble Sort", "Reverse Ordered Array", problemSize);
			betterBubbleResults[2][i] = new AggregateSortAlgorithmProfile("Better Bubble Sort", "Reverse Ordered Array", problemSize);
			quickResults[2][i] = new AggregateSortAlgorithmProfile("Quick Sort", "Reverse Ordered Array", problemSize);
			mergeResults[2][i] = new AggregateSortAlgorithmProfile("Merge Sort", "Reverse Ordered Array", problemSize);
			
			//for the number of iterations specified
			for (int j = 0; j < numberOfIterations; j++) {
				
				
				//run each of the three scenarios and print the individual run results
				
				//random
				System.out.println("=============================");
				System.out.println("Random Array of Size: " + problemSize + " round " + (j + 1));
				System.out.println("=============================");

				Integer[] randomArray = generateRandomArray(problemSize);
				
				SortAlgorithmProfile randomSelectionResult = Sorting.selectionSort(randomArray.clone());
				selectionResults[0][i].addResult(randomSelectionResult);
				System.out.println("Selection Sort: " + System.lineSeparator() + randomSelectionResult);

				SortAlgorithmProfile randomInsertionResult = Sorting.insertionSort(randomArray.clone());
				insertionResults[0][i].addResult(randomInsertionResult);
				System.out.println("Insertion Sort: " + System.lineSeparator() + randomInsertionResult);

				SortAlgorithmProfile randomBubbleResult = Sorting.bubbleSort(randomArray.clone());
				bubbleResults[0][i].addResult(randomBubbleResult);
				System.out.println("Bubble Sort: " + System.lineSeparator() + randomBubbleResult);

				SortAlgorithmProfile randomBetterBubbleResult = Sorting.betterBubbleSort(randomArray.clone());
				betterBubbleResults[0][i].addResult(randomBetterBubbleResult);
				System.out.println("Better Bubble Sort: " + System.lineSeparator() + randomBetterBubbleResult);

				SortAlgorithmProfile randomQuickResult = Sorting.quickSort(randomArray.clone());
				quickResults[0][i].addResult(randomQuickResult);
				System.out.println("Quick Sort: " + System.lineSeparator() + randomQuickResult);

				SortAlgorithmProfile randomMergeResult = Sorting.mergeSort(randomArray.clone());
				mergeResults[0][i].addResult(randomMergeResult);
				System.out.println("Merge Sort: " + System.lineSeparator() + randomMergeResult);

				//sorted
				System.out.println("=============================");
				System.out.println("Sorted Array of Size: " + problemSize + " round " + (j + 1));
				System.out.println("=============================");

				Integer[] orderedArray = generateSortedArray(problemSize);
				SortAlgorithmProfile orderedSelectionResult = Sorting.selectionSort(orderedArray.clone());
				selectionResults[1][i].addResult(orderedSelectionResult);
				System.out.println("Selection Sort: " + System.lineSeparator() + orderedSelectionResult);

				SortAlgorithmProfile orderedInsertionResult = Sorting.insertionSort(orderedArray.clone());
				insertionResults[1][i].addResult(orderedInsertionResult);
				System.out.println("Insertion Sort: " + System.lineSeparator() + orderedInsertionResult);

				SortAlgorithmProfile orderedBubbleResult = Sorting.bubbleSort(orderedArray.clone());
				bubbleResults[1][i].addResult(orderedBubbleResult);
				System.out.println("Bubble Sort: " + System.lineSeparator() + orderedBubbleResult);

				SortAlgorithmProfile orderedBetterBubbleResult = Sorting.betterBubbleSort(orderedArray.clone());
				betterBubbleResults[1][i].addResult(orderedBetterBubbleResult);
				System.out.println("Better Bubble Sort: " + System.lineSeparator() + orderedBetterBubbleResult);

				SortAlgorithmProfile orderedQuickResult = Sorting.quickSort(orderedArray.clone());
				quickResults[1][i].addResult(orderedQuickResult);
				System.out.println("Quick Sort: " + System.lineSeparator() + orderedQuickResult);

				SortAlgorithmProfile orderedMergeResult = Sorting.mergeSort(orderedArray.clone());
				mergeResults[1][i].addResult(orderedMergeResult);
				System.out.println("Merge Sort: " + System.lineSeparator() + orderedMergeResult);

				//reverse sorted
				System.out.println("=============================");
				System.out.println("Reverse Sorted Array of Size: " + problemSize + " round " + (j + 1));
				System.out.println("=============================");

				Integer[] reverseOrderedArray = generateReverseSortedArray(problemSize);

				SortAlgorithmProfile reverseOrderedSelectionResult = Sorting.selectionSort(reverseOrderedArray.clone());
				selectionResults[2][i].addResult(reverseOrderedSelectionResult);
				System.out.println("Selection Sort: " + System.lineSeparator() + reverseOrderedSelectionResult);

				SortAlgorithmProfile reverseOrderedInsertionResult = Sorting.insertionSort(reverseOrderedArray.clone());
				insertionResults[2][i].addResult(reverseOrderedInsertionResult);
				System.out.println("Insertion Sort: " + System.lineSeparator() + reverseOrderedInsertionResult);

				SortAlgorithmProfile reverseOrderedBubbleResult = Sorting.bubbleSort(reverseOrderedArray.clone());
				bubbleResults[2][i].addResult(reverseOrderedBubbleResult);
				System.out.println("Bubble Sort: " + System.lineSeparator() + reverseOrderedBubbleResult);

				SortAlgorithmProfile reverseOrderedBetterBubbleResult = Sorting.betterBubbleSort(reverseOrderedArray.clone());
				betterBubbleResults[2][i].addResult(reverseOrderedBetterBubbleResult);
				System.out.println("Better Bubble Sort: " + System.lineSeparator() + reverseOrderedBetterBubbleResult);

				SortAlgorithmProfile reverseOrderedQuickResult = Sorting.quickSort(reverseOrderedArray.clone());
				quickResults[2][i].addResult(reverseOrderedQuickResult);
				System.out.println("Quick Sort: " + System.lineSeparator() + reverseOrderedQuickResult);

				SortAlgorithmProfile reverseOrderedMergeResult = Sorting.mergeSort(reverseOrderedArray.clone());
				mergeResults[2][i].addResult(reverseOrderedMergeResult);
				System.out.println("Merge Sort: " + System.lineSeparator() + reverseOrderedMergeResult);
			

			
			}
		}
		
		System.out.println("===================RESULTS=========================");

		//Generate a CSV of the results for analysis

		//csv header row
		String csv = "\"Algorithm\",\"Problem Description\",\"Problem Size\",\"Number of Iterations\","
				+ "\"Average Number of Comparisons\",\"Average Duration (ms)\"" + System.lineSeparator();
		
		// generate the individual lines from the AggregateSortAlgorithmProfile data
		for (int i=0; i<=2; i++) {
			for (int j=0; j < problemSizeExponent; j++) {
				csv += generateCSVLine(selectionResults[i][j]);
				System.out.println(selectionResults[i][j]);
				csv += generateCSVLine(insertionResults[i][j]);
				System.out.println(insertionResults[i][j]);
				csv += generateCSVLine(bubbleResults[i][j]);
				System.out.println(bubbleResults[i][j]);
				csv += generateCSVLine(betterBubbleResults[i][j]);
				System.out.println(betterBubbleResults[i][j]);
				csv += generateCSVLine(quickResults[i][j]);
				System.out.println(quickResults[i][j]);
				csv+= generateCSVLine(mergeResults[i][j]);
				System.out.println(mergeResults[i][j]);
			}
		}
		
		// try to write the CSV out to the file system in the working directory
		try {
			FileWriter file = new FileWriter("Asquith_Andrew_T00553858_COMP2231_Assignment1_Resutls.csv");
			file.write(csv);
			file.flush();
			file.close();
		} catch (IOException e) {
			// can't do much if it fails, just print the stack trace
			e.printStackTrace();
		}
		
	}

	/**
	 * Helper method to turn an AggregateSortAlgorithmProfile object into the CSV line
	 * @param profileResults the profile results to convert
	 * @return a line of comma separated values containing the details
	 */
	private static String generateCSVLine(AggregateSortAlgorithmProfile profileResults) {

		return "\"" + profileResults.getSortName() + "\",\"" +
				profileResults.getProblemDescription() + "\",\"" +
				profileResults.getProblemSize() + "\",\"" +
				profileResults.getNumberOfIterations() + "\",\"" +
				profileResults.getAverageNumberOfComparisons() + "\",\"" +
				profileResults.getAverageDurationMilliseconds() +"\"" + 
				System.lineSeparator();
		
	}

	/**
	 * Helper method to generate a sorted array Integers of the provided size
	 * @param size the size of the array to generate
	 * @return an array of the specified size of Integers
	 */
	private static Integer[] generateSortedArray(int size) {

		Integer[] arr = new Integer[size];
		
		for (int i = 0; i < size; i++) {

			// use the index * 2 to give a bit of variety to the data
			arr[i] = new Integer(i * 2);

		}
		return arr;
	}

	/**
	 * Helper method to generate a reverse sorted array of Integers of the
	 * provided size
	 * @param size the size of the array to generate
	 * @return an array of the specified size of Integers reverse sorted
	 */
	private static Integer[] generateReverseSortedArray(int size) {

		Integer[] arr = new Integer[size];
		//start at the largest value and work back to 0
		for (int i = size - 1; i >= 0; i--) {
			//use i*2 for some variety in the numbers while still maintaining order
			arr[(size - 1) - i] = new Integer(i * 2);

		}
		return arr;
	}

	/**
	 * Helper method to generate an array of random Integers 
	 * of the specified size
	 * @param size the size of the array to generate
	 * @return an array of the specified size of Integers in random order
	 */
	private static Integer[] generateRandomArray(int size) {
		Integer[] arr = new Integer[size];
		// use the random number generator instead of Math.Random
		Random rng = new Random();

		// fill the array to whatever size was requested
		for (int i = 0; i < size; i++) {
			// use the whole 2^32 range for possible values
			// data[i] = new Integer(rng.nextInt());
			// size * 10 as the upper bound
			arr[i] = new Integer(rng.nextInt(size * 10) + 1);
		}
		return arr;
	}
}