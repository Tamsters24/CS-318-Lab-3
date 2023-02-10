/* Sorts318.java
*  Steve Sheehy
*  January, 2022
*
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
        /*
        for (int j = 0; j < (a.length - 1); j++) {
            if (a[j] <= a[j + 1]) {}
            else

        }
        */

    }

    public static void selectionSort(int[] a){
        //put your code here
        System.out.println("Inside selectionSort");

        int remaining_entries = a.length;
        int index_at_min, current_min;
        int temporary_value;

        for (int i = 0; i < (remaining_entries - 1); i++) {
            // First, find index min of smallest remaining entry
            index_at_min = i;
            temporary_value = a[i];
            current_min = a[i];

            for (int j = i + 1; j < remaining_entries; j++) {
                if (current_min <= a[j]) { /* do nothing */ }
                else {
                    current_min = a[j];
                    index_at_min = j;
                }
            }
            System.out.println("Current i = " + i);
            System.out.println("Element at i = " + a[i]);
            System.out.println("Current min = " + current_min);
            System.out.println("Index at min = " + index_at_min + "\n");

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

          list[0] = 7;
          list[1] = 10;
          list[2] = 5;
          list[3] = 3;
          list[4] = 8;
          list[5] = 4;
          list[6] = 2;
          list[7] = 9;
          list[8] = 6;

          System.out.println("unsorted array: " + Arrays.toString(list) + "\n\n");

          System.out.println("testing sort...");
          //Arrays.sort(list);
          selectionSort(list);
          //insertionSort(list);



          System.out.println("sorted array: " + Arrays.toString(list) + "\n\n");

          System.out.println("testing isSorted");
          System.out.println("isSorted (should be true): " + isSorted(list));

          list[list.length/2] = 23412341;
          System.out.println("test array: " + Arrays.toString(list) + "\n");
          System.out.println("isSorted (should be false): " + isSorted(list));
    }

}
