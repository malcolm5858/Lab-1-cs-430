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

        return [insertionTime, mergeTime];
    }

    int[] randomize(int arraysize) {
        return null;
    }

    void mergeSort() {

    }

    void insertionSort() {
        
    }
}