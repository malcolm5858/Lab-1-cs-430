
//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class RadixSort {
    public static void sort(int array[]) {
        int max = getMax(array);
        // Go through each digit of the numbers in the array to sort
        for (int exp = 1; max / exp > 0; exp *= 10) {
            // use a modified version of count sort to sort the array by digit
            countSort(array, exp);
        }
    }

    // Function to get the maximum value from the array
    private static int getMax(int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Same as regular counting sort but uses a exponent value to split it up by a
    // individual digit
    public static void countSort(int[] array, int exp) {
        int[] result = new int[array.length]; // initialize result array

        int[] count = new int[10]; // initialize counting array (holds the number of instances of each number)
        for (int i = 0; i < 10; i++) { // clear array to zero
            count[i] = 0;
        }

        for (int j = 0; j < array.length; j++) { // for each element in the initial array
            count[(array[j] / exp) % 10]++; // increment the corresponding element of the count array
        }

        for (int i = 1; i < 10; i++) { // iterates through the count array and adds all the previous values
            count[i] += count[i - 1]; // the count array contains a record of how many values <= i
        }

        for (int j = array.length - 1; j >= 0; j--) { // for each element in the initial array
            result[count[(array[j] / exp) % 10] - 1] = array[j]; // insert it in the correct location by checking the
                                                                 // count array for the number of values below it
            count[(array[j] / exp) % 10]--; // decrement the value in the count array to handle duplicates
        }

        for (int j = 0; j < array.length; j++) { // copy result array back to input array
            array[j] = result[j];
        }
    }
}