import java.util.Arrays;
import java.util.Random;

public class lab1 {
    public static int[] unsorted; //initial unsorted array
    public static int[] mergeResult; //output array of merge sort
    public static int[] insertionResult; //output array of insertion sort
    public static long mergeTime; //time taken for merge sort function (ms)
    public static long insertionTime; //time taken for insertion sort function (ms)

    public static long[] run(int arraySize) { //main backend function
        unsorted = randomize(arraySize); //create random array
        insertionResult = unsorted; //copy into new arrays for each function
        mergeResult = unsorted;

        System.out.println(Arrays.toString(unsorted)); // prints unsorted array to console so you can confirm results

        long start = System.currentTimeMillis(); //gets current system time for performance calculation
        insertionSort(insertionResult); //perform insertion sort
        insertionTime = System.currentTimeMillis() - start; //subtract current system time from start value to get performance results

        System.out.println(Arrays.toString(insertionResult)); //prints sorted array to console for confirmation

        start = System.currentTimeMillis(); //gets current system time for performance calculation
        mergeSort(mergeResult, 0, arraySize); //perform merge sort
        mergeTime = System.currentTimeMillis() - start; //subtract current system time from start value to get performance results

        System.out.println(Arrays.toString(mergeResult)); //prints sorted array to console for confirmation

        return new long[] { insertionTime, mergeTime }; //returns performance results to frontend
    }

    static int[] randomize(int arraysize) { //generates a list of randomized ints
        Random r = new Random(); //create an instance of Random that we use to generate random numbers

        int[] array = new int[arraysize]; //create the array
        for (int i = 0; i < arraysize; i++) { //populate each element iteravely
            array[i] = r.nextInt(); //generates random integers
        }

        return array;
    }

    static void merge(int[] array, int start, int split, int end) { // start index, index beginning the second array,
                                                                    // and index after the end of the second array
        int[] a = new int[split - start]; //new arrays for each half of the merge
        int[] b = new int[end - split];

        for (int i = 0; i < a.length; i++) { //copying from main array into new arrays a and b
            a[i] = array[i + start];
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = array[i + split];
        }

        int ai = 0; //increment variables for each of the temporary arrays
        int bi = 0;
        for (int i = start; i < end; i++) { //increment through the relevant section of the array
            if (ai == a.length || a[ai] > b[bi]) { //if the next lowest element is in b, it gets transferred.
                array[i] = b[bi];                  //we also check if we're done iterating through a here.
                bi++;
            } else if (bi == b.length || a[ai] <= b[bi]) { //otherwise, the element in a gets transferred
                array[i] = a[ai];
                ai++;
            }
        }
    }

    static void mergeSort(int[] array, int start, int end) { //we take the array, and a start and end index for recursion
        if (start < end - 1) { //empty base case because the entire sorting operation takes place in the merge
            int split = (start + end) / 2; //integer division gives the floor, so this gives an adequate split location
            mergeSort(array, start, split); //recursion on each half of the array
            mergeSort(array, split, end);
            merge(array, start, split, end); //merge operation on each sorted half
        }
    }

    static void insertionSort(int[] array) { //just takes an array, not recursive
        for (int i = 0; i < array.length; i++) { //iterate through array
            for (int j = i; j > 0; j--) { //iterate backwards to find insertion point
                if (array[j] < array[j - 1]) { //check against previous element to see it should go further
                    int temp = array[j]; //swap array[j] and array[j-1]
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else { //if we don't need to go back further, we're done inserting this element and can exit the inner loop
                    break;
                }
            }
        }
    }
}