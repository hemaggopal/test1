package com.infosys.learning.efficientCodingSamples;

/**
 * A line has formed to buy tickets for a concert. In order to delay a shortage
 * caused by brokers buying large blocks of tickets, venue management has
 * decided to sell only one ticket at a time. Buyers have to to wait through
 * line again if they want to buy more tickets. Jesse is standing in line and
 * has a number of tickets to purchase.
 * 
 * Given a list of ticket buyers with their numbers of desired tickets,
 * determine how long it will take Jesse to purchase his tickets. Jesse's
 * position in line will be stated, and each transaction takes 1 unit of time.
 * For your purposes, no time is spent moving to the back of the line.
 * 
 * For example, if the zero indexed array of ticket requirements, tickets = [1,
 * 2, 5] , and Jesse's position p = 1
 * 
 * @author hemalatha.gopal
 *
 */
public class BuyingTickets {
	static int countTraversals(int[] arr, int p) {
		int count = 0;
		int i = 0;

		while (arr[p] != 0) {
			// System.out.println(i + "," + arr[i] + ", " + Arrays.toString(arr));

			if (arr[i] != 0) {
				count++;
				--arr[i];
			}
			if (i == (arr.length - 1))
				i = 0;
			else
				i++;

		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 3, 4, 5, 2 };// { 1, 2, 5 };
		int p = 7;
		System.out.println(countTraversals(arr, p - 1));
	}
}
