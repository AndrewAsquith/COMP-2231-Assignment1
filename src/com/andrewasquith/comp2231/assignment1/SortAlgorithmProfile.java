package com.andrewasquith.comp2231.assignment1;

import java.time.Duration;
import java.time.Instant;

public class SortAlgorithmProfile {

	private long numberOfComparisons;
	private boolean timerIsRunning;
	
	private Instant startTime, endTime;
	
	public long getNumberOfComparisons() {
		return numberOfComparisons;
	}
	
	public void addComparison() {
		numberOfComparisons++;
	}
	
	public void startTimer() {

		timerIsRunning = true;
		startTime = Instant.now();
	}
	
	public void stopTimer() {
		endTime = Instant.now();
		timerIsRunning = false;
	}
	
	public Duration getDuration() {
		if (timerIsRunning) {
			return Duration.between(startTime, Instant.now());
		} else {
			return Duration.between(startTime, endTime);
		}
	}
	
	public String toString() {
		
		return "Number of Comparisons: " + numberOfComparisons + System.lineSeparator()
			+ "Performed in " + getDuration().toMillis() + " milliseconds";
	}
}
