class Lab1 {
    public int[] unsorted;
    public int[] mergeResult;
    public int[] insertionResult;
    public double mergeTime;
    public double insertionTime;


    double[] run(int arraySize) {
        unsorted = randomize(arraySize);
        
        long start = System.currentTimeMillis();
        insertionSort();
        insertionTime = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        mergeSort();
        mergeTime = System.currentTimeMillis() - start;

        return new double[]{insertionTime, mergeTime};
    }

    int[] randomize(int arraysize) {
        return null;
    }

    void merge (int[] array, int start, int split, int end) { //start index, index beginning the second array, and index after the end of the second array
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

    void mergeSort() {

    }

    void insertionSort() {
        
    }
}