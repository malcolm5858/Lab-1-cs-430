//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class QuickSort {
    public static void sort(int[] array, int start, int end) {
        if (start < end - 1) { // base case: zero elements in array, no pivot
            int mid = partition(array, start, end); // partition array into two and get pivot
            sort(array, start, mid); // recursively sort on either side of the pivot
            sort(array, mid + 1, end);
        }
    }

    static int partition(int[] array, int start, int end) {
        int pivot = array[start]; // create pivot
        int i = start + 1; // keeps track of the location the pivot will swap into when done
        for (int j = i; j < end; j++) { // iterates through all of array except the pivot
            if (array[j] <= pivot) { // if element is smaller than pivot
                array = swap(array, i, j); // swap with the currently tracked pivot position
                i++; // increment pivot position
            }
        }

        array = swap(array, start, i - 1); // swap the pivot into place
        return i - 1; // return pivot location to sort
    }

    static int[] swap(int[] array, int i, int j) { // basic java swap function
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
}