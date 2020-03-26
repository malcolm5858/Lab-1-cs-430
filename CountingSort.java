//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060

public class CountingSort {
    public static void sort(int[] array, int max) {
        int[] result = new int[array.length]; // initialize result array

        int[] count = new int[max + 1]; // initialize counting array (holds the number of instances of each number)
        for (int i = 0; i <= max; i++) { // clear array to zero
            count[i] = 0;
        }

        for (int j = 0; j < array.length; j++) { // for each element in the initial array
            count[array[j]]++; // increment the corresponding element of the count array
        }

        for (int i = 1; i <= max; i++) { // iterates through the count array and adds all the previous values
            count[i] += count[i - 1]; // the count array contains a record of how many values <= i
        }

        for (int j = array.length - 1; j >= 0; j--) { // for each element in the initial array
            result[count[array[j]] - 1] = array[j]; // insert it in the correct location by checking the count array for
                                                    // the number of values below it
            count[array[j]]--; // decrement the value in the count array to handle duplicates
        }

        for (int j = 0; j < array.length; j++) { // copy result array back to input array
            array[j] = result[j];
        }
    }
}