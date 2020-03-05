//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class MergeSort {
    static void merge(int[] array, int start, int split, int end) { // start index, index beginning the second array,
                                                                    // and index after the end of the second array
        int[] a = new int[split - start]; // new arrays for each half of the merge
        int[] b = new int[end - split];

        for (int i = 0; i < a.length; i++) { // copying from main array into new arrays a and b
            a[i] = array[i + start];
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = array[i + split];
        }

        int ai = 0; // increment variables for each of the temporary arrays
        int bi = 0;
        for (int i = start; i < end; i++) { // increment through the relevant section of the array
            if (ai == a.length || a[ai] > b[bi]) { // if the next lowest element is in b, it gets transferred.
                array[i] = b[bi]; // we also check if we're done iterating through a here.
                bi++;
            } else if (bi == b.length || a[ai] <= b[bi]) { // otherwise, the element in a gets transferred
                array[i] = a[ai];
                ai++;
            }
        }
    }

    public static void sort(int[] array, int start, int end) { // we take the array, and a start and end index for
                                                               // recursion
        if (start < end - 1) { // empty base case because the entire sorting operation takes place in the merge
            int split = (start + end) / 2; // integer division gives the floor, so this gives an adequate split location
            sort(array, start, split); // recursion on each half of the array
            sort(array, split, end);
            merge(array, start, split, end); // merge operation on each sorted half
        }
    }
}