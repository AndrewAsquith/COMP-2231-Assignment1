package com.andrewasquith.comp2231.assignment1;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class SortComparisonRunner {

	public static void main(String[] args) {

		// selection sort, insertion sort, bubble sort, quick sort, and merge
		// sort

		for (int i = 10; i <= 100000; i *= 10) {

			System.out.println("=============================");
			System.out.println("Random Array of Size: " + i);
			System.out.println("=============================");

			Integer[] randomArray = generateRandomArray(i);
			SortAlgorithmProfile randomSelectionResult = Sorting.selectionSort(randomArray);
			System.out.println("Selection Sort: " + System.lineSeparator() + randomSelectionResult);

			SortAlgorithmProfile randomInsertionResult = Sorting.insertionSort(randomArray);
			System.out.println("Insertion Sort: " + System.lineSeparator() + randomInsertionResult);

			SortAlgorithmProfile randomBubbleResult = Sorting.bubbleSort(randomArray);
			System.out.println("Bubble Sort: " + System.lineSeparator() + randomBubbleResult);

			SortAlgorithmProfile randomQuickResult = Sorting.quickSort(randomArray);
			System.out.println("Quick Sort: " + System.lineSeparator() + randomQuickResult);

			SortAlgorithmProfile randomMergeResult = Sorting.mergeSort(randomArray);
			System.out.println("Merge Sort: " + System.lineSeparator() + randomMergeResult);

			System.out.println("=============================");
			System.out.println("Sorted Array of Size: " + i);
			System.out.println("=============================");

			Integer[] orderedArray = generateSortedArray(i);
			SortAlgorithmProfile orderedSelectionResult = Sorting.selectionSort(orderedArray);
			System.out.println("Selection Sort: " + System.lineSeparator() + orderedSelectionResult);

			SortAlgorithmProfile orderedInsertionResult = Sorting.insertionSort(orderedArray);
			System.out.println("Insertion Sort: " + System.lineSeparator() + orderedInsertionResult);

			SortAlgorithmProfile orderedBubbleResult = Sorting.bubbleSort(orderedArray);
			System.out.println("Bubble Sort: " + System.lineSeparator() + orderedBubbleResult);

			SortAlgorithmProfile orderedQuickResult = Sorting.quickSort(orderedArray);
			System.out.println("Quick Sort: " + System.lineSeparator() + orderedQuickResult);

			SortAlgorithmProfile orderedMergeResult = Sorting.mergeSort(orderedArray);
			System.out.println("Merge Sort: " + System.lineSeparator() + orderedMergeResult);

		}
	}

	private static Integer[] generateSortedArray(int size) {

		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Integer(i * 2);

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
