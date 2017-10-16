package com.andrewasquith.comp2231.assignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class SortComparisonRunner {

	public static void main(String[] args) {

		// selection sort, insertion sort, bubble sort, quick sort, and merge

		final int numberOfIterations = 10;
		final int problemSizeBase = 10;
		final int problemSizeExponent = 4;

		AggregateSortAlgorithmProfile[][] selectionResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] insertionResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] bubbleResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] betterBubbleResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] quickResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		AggregateSortAlgorithmProfile[][] mergeResults = new AggregateSortAlgorithmProfile[3][problemSizeExponent];
		
	
		
		for (int i = 0; i < problemSizeExponent; i++) {

			int problemSize = (int)Math.pow(problemSizeBase, i+1);
			
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
			
			for (int j = 0; j < numberOfIterations; j++) {
				
				System.out.println("=============================");
				System.out.println("Random Array of Size: " + problemSize + " round " + (j + 1));
				System.out.println("=============================");

				Integer[] randomArray = generateRandomArray(problemSize);
				
				SortAlgorithmProfile randomSelectionResult = Sorting.selectionSort(randomArray);
				selectionResults[0][i].addResult(randomSelectionResult);
				System.out.println("Selection Sort: " + System.lineSeparator() + randomSelectionResult);

				SortAlgorithmProfile randomInsertionResult = Sorting.insertionSort(randomArray);
				insertionResults[0][i].addResult(randomInsertionResult);
				System.out.println("Insertion Sort: " + System.lineSeparator() + randomInsertionResult);

				SortAlgorithmProfile randomBubbleResult = Sorting.bubbleSort(randomArray);
				bubbleResults[0][i].addResult(randomBubbleResult);
				System.out.println("Bubble Sort: " + System.lineSeparator() + randomBubbleResult);

				SortAlgorithmProfile randomBetterBubbleResult = Sorting.betterBubbleSort(randomArray);
				betterBubbleResults[0][i].addResult(randomBetterBubbleResult);
				System.out.println("Better Bubble Sort: " + System.lineSeparator() + randomBetterBubbleResult);

				SortAlgorithmProfile randomQuickResult = Sorting.quickSort(randomArray);
				quickResults[0][i].addResult(randomQuickResult);
				System.out.println("Quick Sort: " + System.lineSeparator() + randomQuickResult);

				SortAlgorithmProfile randomMergeResult = Sorting.mergeSort(randomArray);
				mergeResults[0][i].addResult(randomMergeResult);
				System.out.println("Merge Sort: " + System.lineSeparator() + randomMergeResult);

				System.out.println("=============================");
				System.out.println("Sorted Array of Size: " + problemSize + " round " + (j + 1));
				System.out.println("=============================");

				Integer[] orderedArray = generateSortedArray(problemSize);
				SortAlgorithmProfile orderedSelectionResult = Sorting.selectionSort(orderedArray);
				selectionResults[1][i].addResult(orderedSelectionResult);
				System.out.println("Selection Sort: " + System.lineSeparator() + orderedSelectionResult);

				SortAlgorithmProfile orderedInsertionResult = Sorting.insertionSort(orderedArray);
				insertionResults[1][i].addResult(orderedInsertionResult);
				System.out.println("Insertion Sort: " + System.lineSeparator() + orderedInsertionResult);

				SortAlgorithmProfile orderedBubbleResult = Sorting.bubbleSort(orderedArray);
				bubbleResults[1][i].addResult(orderedBubbleResult);
				System.out.println("Bubble Sort: " + System.lineSeparator() + orderedBubbleResult);

				SortAlgorithmProfile orderedBetterBubbleResult = Sorting.betterBubbleSort(orderedArray);
				betterBubbleResults[1][i].addResult(orderedBetterBubbleResult);
				System.out.println("Better Bubble Sort: " + System.lineSeparator() + orderedBetterBubbleResult);

				SortAlgorithmProfile orderedQuickResult = Sorting.quickSort(orderedArray);
				quickResults[1][i].addResult(orderedQuickResult);
				System.out.println("Quick Sort: " + System.lineSeparator() + orderedQuickResult);

				SortAlgorithmProfile orderedMergeResult = Sorting.mergeSort(orderedArray);
				mergeResults[1][i].addResult(orderedMergeResult);
				System.out.println("Merge Sort: " + System.lineSeparator() + orderedMergeResult);

				System.out.println("=============================");
				System.out.println("Reverse Sorted Array of Size: " + problemSize + " round " + (j + 1));
				System.out.println("=============================");

				Integer[] reverseOrderedArray = generateReverseSortedArray(problemSize);

				SortAlgorithmProfile reverseOrderedSelectionResult = Sorting.selectionSort(reverseOrderedArray);
				selectionResults[2][i].addResult(reverseOrderedSelectionResult);
				System.out.println("Selection Sort: " + System.lineSeparator() + reverseOrderedSelectionResult);

				SortAlgorithmProfile reverseOrderedInsertionResult = Sorting.insertionSort(reverseOrderedArray);
				insertionResults[2][i].addResult(reverseOrderedInsertionResult);
				System.out.println("Insertion Sort: " + System.lineSeparator() + reverseOrderedInsertionResult);

				SortAlgorithmProfile reverseOrderedBubbleResult = Sorting.bubbleSort(reverseOrderedArray);
				bubbleResults[2][i].addResult(reverseOrderedBubbleResult);
				System.out.println("Bubble Sort: " + System.lineSeparator() + reverseOrderedBubbleResult);

				SortAlgorithmProfile reverseOrderedBetterBubbleResult = Sorting.betterBubbleSort(reverseOrderedArray);
				betterBubbleResults[2][i].addResult(reverseOrderedBetterBubbleResult);
				System.out.println("Better Bubble Sort: " + System.lineSeparator() + reverseOrderedBetterBubbleResult);

				SortAlgorithmProfile reverseOrderedQuickResult = Sorting.quickSort(reverseOrderedArray);
				quickResults[2][i].addResult(reverseOrderedQuickResult);
				System.out.println("Quick Sort: " + System.lineSeparator() + reverseOrderedQuickResult);

				SortAlgorithmProfile reverseOrderedMergeResult = Sorting.mergeSort(reverseOrderedArray);
				mergeResults[2][i].addResult(reverseOrderedMergeResult);
				System.out.println("Merge Sort: " + System.lineSeparator() + reverseOrderedMergeResult);
			

			
			}
		}
		
		System.out.println("===================RESULTS=========================");
//		int i = 1;
		String csv = "\"Algorithm\",\"Problem Description\",\"Problem Size\",\"Number of Iterations\","
				+ "\"Average Number of Comparisons\",\"Average Duration (ms)\"" + System.lineSeparator();
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
		
		try {
			FileWriter file = new FileWriter("Asquith_Andrew_T00553858_COMP2231_Assignment1_Resutls.csv");
			file.write(csv);
			file.flush();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String generateCSVLine(AggregateSortAlgorithmProfile profileResults) {

		return "\"" + profileResults.getSortName() + "\",\"" +
				profileResults.getProblemDescription() + "\",\"" +
				profileResults.getProblemSize() + "\",\"" +
				profileResults.getNumberOfIterations() + "\",\"" +
				profileResults.getAverageNumberOfComparisons() + "\",\"" +
				profileResults.getAverageDurationMilliseconds() +"\"" + 
				System.lineSeparator();
		
	}

	private static Integer[] generateSortedArray(int size) {

		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Integer(i * 2);

		}
		return arr;
	}

	private static Integer[] generateReverseSortedArray(int size) {

		Integer[] arr = new Integer[size];
		for (int i = size - 1; i >= 0; i--) {
			arr[(size - 1) - i] = new Integer(i * 2);

		}
		return arr;
	}

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
