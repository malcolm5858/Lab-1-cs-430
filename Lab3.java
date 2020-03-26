import java.util.Arrays;
import java.util.Random;

//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class Lab3 {
    public static int[] unsorted; // initial unsorted array
    public static int[] quickResult; // output array of quick sort
    public static int[] heapResult; // output array of heap sort
    public static long quickTime; // time taken for quick sort function (ms)
    public static long heapTime; // time taken for heap sort function (ms)

    public static long[] run(int arraySize) { // main backend function
        unsorted = randomize(arraySize); // create random array
        heapResult = unsorted.clone(); // copy into new arrays for each function
        quickResult = unsorted.clone();

        // System.out.println(Arrays.toString(unsorted)); // prints unsorted array to
        // console so you can confirm results

        long start = System.currentTimeMillis(); // gets current system time for performance calculation
        HeapSort.sort(heapResult); // perform heap sort
        heapTime = System.currentTimeMillis() - start; // subtract current system time from start value to get
                                                       // performance results

        // System.out.println(Arrays.toString(heapResult)); // prints sorted array
        // to console for confirmation

        start = System.currentTimeMillis(); // gets current system time for performance calculation
        QuickSort.sort(quickResult, 0, arraySize); // perform quick sort
        quickTime = System.currentTimeMillis() - start; // subtract current system time from start value to get
                                                        // performance results

        // System.out.println(Arrays.toString(quickResult)); // prints sorted array to
        // console for confirmation

        return new long[] { heapTime, quickTime }; // returns performance results to frontend
    }

    static int[] randomize(int arraySize) { // generates a list of randomized ints
        Random r = new Random(); // create an instance of Random that we use to generate random numbers

        int[] array = new int[arraySize]; // create the array
        for (int i = 0; i < arraySize; i++) { // populate each element iteravely
            array[i] = r.nextInt(); // generates random integers
        }

        return array;
    }
}