///Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class InsertionSort {
    public static void sort(int[] array) { // just takes an array, not recursive
        for (int i = 0; i < array.length; i++) { // iterate through array
            for (int j = i; j > 0; j--) { // iterate backwards to find insertion point
                if (array[j] < array[j - 1]) { // check against previous element to see it should go further
                    int temp = array[j]; // swap array[j] and array[j-1]
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else { // if we don't need to go back further, we're done inserting this element and
                         // can exit the inner loop
                    break;
                }
            }
        }
    }
}