/* Sorts318.java
*  Steve Sheehy
*  January, 2022
*
*  Revised by Tammy Busche
*  CS 318: Algorithm Analysis
*  68211-Winter 2023
*  Lab 3
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

public class SortsLab1 {

    public static boolean isSorted(int[] a) {
        //put your code here
        boolean neighborCheck = true;
        for (int i = 0; i < (a.length - 1); i++)
            if (a[i] > a[i + 1])
                return false;
        return neighborCheck;
    }

    public static void insertionSort(int[] a){
        //put your code here
        int temporary_value, larger_left;

        for (int i = 1; i < a.length; i++) {
            // In iteration i, swap a[i] with each larger entry to its left.
            // Because a[0] has no entries left of it, start at i = 1.

            for (int j = i; j > 0; j --) {
                if (a[j-1] > a[j]) {
                    temporary_value = a[j];
                    larger_left = a[j-1];

                    // swap values
                    a[j] = larger_left;
                    a[j-1] = temporary_value;

                    // iterate until the temporary value does not have a
                    // larger entry to its left
                }
            }
        }
    }

    public static void selectionSort(int[] a){
        //put your code here
        int remaining_entries = a.length;
        int temporary_value, index_at_min, current_min;

        for (int i = 0; i < (remaining_entries - 1); i++) {
            // First, find index min of smallest remaining entry,
            // don't need to do this for the last entry
            temporary_value = a[i];
            index_at_min = i;
            current_min = a[i];

            for (int j = i + 1; j < remaining_entries; j++) {
                if (current_min > a[j]) {
                    current_min = a[j];
                    index_at_min = j;
                }
            }

            // Then, swap a[i] and a[min]
            a[i] = current_min;
            a[index_at_min] = temporary_value;

            // Repeat for remaining entries
        }
    }


    public static void main(String[] args){

        long count = 0;
        Integer nInt = new Integer(args[0]);
        int n = nInt.intValue();

        System.out.println("generating array of random values of size: " + n + "\n");

        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = StdRandom.uniform(0, n);

        System.out.println("unsorted array: " + Arrays.toString(list) + "\n\n");

        System.out.println("testing sort...");
        //Arrays.sort(list);
        //selectionSort(list);
        insertionSort(list);


        System.out.println("sorted array: " + Arrays.toString(list) + "\n\n");

        System.out.println("testing isSorted");
        System.out.println("isSorted (should be true): " + isSorted(list));

        list[list.length/2] = 23412341;
        System.out.println("test array: " + Arrays.toString(list) + "\n");
        System.out.println("isSorted (should be false): " + isSorted(list));
    }
}