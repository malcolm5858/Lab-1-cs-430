///Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class HeapSort {
    public static void sort(int[] array) {
        // build the heap by going through the heap and heapifing the different
        // subtree's
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // go through the array and move the root node to the top of the heap and
        // replace it with the value at the end of the array
        for (int i = array.length - 1; i >= 0; i--) {
            array = swap(array, 0, i);
            // re heapify
            heapify(array, i, 0);
        }
    }

    // int i is a index in the array int s is the size of the heap
    static void heapify(int[] array, int s, int i) {
        // the root of the tree or of the subtree that is getting heapified
        int root = i;
        // find its left and right node
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // if the left node is greater then the root node set the root node to the left
        // node
        if (l < s && array[l] > array[root]) {
            root = l;
        }

        // if the right node is greater then the root node set the root node to the
        // right node
        if (r < s && array[r] > array[root]) {
            root = r;
        }
        // Swap the nodes then reheapify with the new root node
        if (root != i) {
            array = swap(array, i, root);
            // re heapify with the new root node
            heapify(array, s, root);
        }
    }

    public static int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
}
