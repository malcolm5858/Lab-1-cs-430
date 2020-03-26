import java.util.Arrays;
import java.util.Random;

//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class Lab4 {
    public static int[] unsorted; // initial unsorted array
    public static int[] countingResult; // output array of counting sort
    public static int[] radixResult; // output array of radix sort
    public static long countingTime; // time taken for counting sort function (ms)
    public static long radixTime; // time taken for radix sort function (ms)

    public static long[] run(int arraySize) { // main backend function
        unsorted = randomize(arraySize); // create random array
        radixResult = unsorted.clone(); // copy into new arrays for each function
        countingResult = unsorted.clone();

        // System.out.println(Arrays.toString(unsorted)); // prints unsorted array to
        // console so you can confirm results

        long start = System.currentTimeMillis(); // gets current system time for performance calculation
        RadixSort.sort(radixResult); // perform radix sort
        radixTime = System.currentTimeMillis() - start; // subtract current system time from start value to get
                                                        // performance results

        // System.out.println(Arrays.toString(radixResult)); // prints sorted array
        // to console for confirmation

        start = System.currentTimeMillis(); // gets current system time for performance calculation
        CountingSort.sort(countingResult, getMax(countingResult)); // perform counting sort
        countingTime = System.currentTimeMillis() - start; // subtract current system time from start value to get
                                                           // performance results

        // System.out.println(Arrays.toString(countingResult)); // prints sorted array
        // to
        // console for confirmation

        return new long[] { radixTime, countingTime }; // returns performance results to frontend
    }

    static int[] randomize(int arraySize) { // generates a list of randomized ints
        Random r = new Random(); // create an instance of Random that we use to generate random numbers

        int[] array = new int[arraySize]; // create the array
        for (int i = 0; i < arraySize; i++) { // populate each element iteravely
            array[i] = Math.abs(r.nextInt(10000000)); // generates random integers
        }

        return array;
    }

    private static int getMax(int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
