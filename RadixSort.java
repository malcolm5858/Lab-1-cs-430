
//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060
public class RadixSort {
    public static void sort(int array[]) {
        int max = getMax(array);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
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

    public static void countSort(int[] array, int exp) {
        int[] result = new int[array.length];

        int[] count = new int[10];
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        for (int j = 0; j < array.length; j++) {
            count[(array[j] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            result[count[(array[j] / exp) % 10] - 1] = array[j];
            count[(array[j] / exp) % 10]--;
        }

        for (int j = 0; j < array.length; j++) {
            array[j] = result[j];
        }
    }
}