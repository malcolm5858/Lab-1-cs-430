//Team Yamaha piano: Malcolm Machesky seatNo: 45 CWID: A20414760, Adrian Kirchner seatNo: 34 CWID: A20425060

public class CountingSort {
    public static void sort(int[] array, int max) {
        int[] result = new int[array.length];

        int[] count = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        for (int j = 0; j < array.length; j++) {
            count[array[j]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            result[count[array[j]] - 1] = array[j];
            count[array[j]]--;
        }

        for (int j = 0; j < array.length; j++) {
            array[j] = result[j];
        }
    }
}