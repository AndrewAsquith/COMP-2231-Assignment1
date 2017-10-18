/**
 * COMP-2231 Assignment 1 package
 * @author Andrew Asquith
 */
package com.andrewasquith.comp2231.assignment1;

//import the instant and duration classes from Java8 java.time
import java.time.Duration;
import java.time.Instant;

/**
 * 
 * Class containing interesting data about a sort algorithm
 *
 */
public class SortAlgorithmProfile {

	/**
	 * The number of comparisons recorded
	 */
	private long numberOfComparisons;
	
	/**
	 * internal indicator if the timer is running
	 */
	private boolean timerIsRunning;
	
	
	/**
	 * Instants to capture start and end time
	 * Requires Java 8
	 */
	private Instant startTime, endTime;
	
	/**
	 * Getter for the number of comparisons recorded
	 * @return the number of comparisons recorded
	 */
	public long getNumberOfComparisons() {
		return numberOfComparisons;
	}
	
	/**
	 * Records a comparison
	 */
	public void addComparison() {
		numberOfComparisons++;
	}
	
	/**
	 * Records the current time as the start of the timer
	 */
	public void startTimer() {

		timerIsRunning = true;
		startTime = Instant.now();
	}
	
	/**
	 * Records the current time as the stop of the timer
	 */
	public void stopTimer() {
		endTime = Instant.now();
		timerIsRunning = false;
	}
	
	/**
	 * Returns the duration of the timer. 
	 * If stopTimer has not been called "now" is used as the end time
	 * 
	 * @return Duration object of difference between start and end times
	 */
	public Duration getDuration() {
		if (timerIsRunning) {
			return Duration.between(startTime, Instant.now());
		} else {
			return Duration.between(startTime, endTime);
		}
	}
	
	/**
	 * String representation of the profile
	 */
	public String toString() {
		
		return "Number of Comparisons: " + numberOfComparisons + System.lineSeparator()
			+ "Performed in " + getDuration().toMillis() + " milliseconds";
	}
}
