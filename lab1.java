import java.util.Random;

public class lab1 {
    public static int[] unsorted;
    public static int[] mergeResult;
    public static int[] insertionResult;
    public static double mergeTime;
    public static double insertionTime;


    public static double[] run(int arraySize) {
        unsorted = randomize(arraySize);
        insertionResult = unsorted;
        mergeResult = unsorted;

        System.out.println(unsorted);

        long start = System.currentTimeMillis();
        insertionSort(insertionResult);
        insertionTime = System.currentTimeMillis() - start;
        
        System.out.println(insertionResult);

        start = System.currentTimeMillis();
        mergeSort(mergeResult, 0, arraySize);
        mergeTime = System.currentTimeMillis() - start;

        System.out.println(mergeResult);

        return new double[]{insertionTime, mergeTime};
    }

    static int[] randomize(int arraysize) {
        Random r = new Random();

        int[] array = new int[arraysize];
        for (int i = 0; i < arraysize; i++) {
            array[i] = r.nextInt();
        }

        return array;
    }

    static void merge (int[] array, int start, int split, int end) { //start index, index beginning the second array, and index after the end of the second array
        int[] a = new int[split - start];
        int[] b = new int[end - split];

        for (int i = 0; i < a.length; i++) {
            a[i] = array[i + start];
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = array[i + split];
        }

        int ai = 0;
        int bi = 0;
        for (int i = start; i < end; i++) {
            if (ai == a.length || a[ai] > b[bi]) {
                array[i] = b[bi];
                bi++;
            }
            else if (bi == b.length || a[ai] <= b[bi]) {
                array[i] = a[ai];
                ai++;
            }
        }
    }

    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int split = (start + end) / 2;
            mergeSort(array, start, split);
            mergeSort(array, split, end);
            merge(array, start, split, end);
        }
    }

    static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }
}