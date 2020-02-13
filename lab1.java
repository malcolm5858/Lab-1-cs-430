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

        //System.out.println(Arrays.toString(unsorted)); // prints unsorted array to console so you can confirm results

        long start = System.currentTimeMillis(); //gets current system time for performance calculation
        InsertionSort.sort(insertionResult); //perform insertion sort
        insertionTime = System.currentTimeMillis() - start; //subtract current system time from start value to get performance results

        //System.out.println(Arrays.toString(insertionResult)); //prints sorted array to console for confirmation

        start = System.currentTimeMillis(); //gets current system time for performance calculation
        MergeSort.sort(mergeResult, 0, arraySize); //perform merge sort
        mergeTime = System.currentTimeMillis() - start; //subtract current system time from start value to get performance results

        //System.out.println(Arrays.toString(mergeResult)); //prints sorted array to console for confirmation

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
}