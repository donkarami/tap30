import java.util.*;

public class PairsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float n = scanner.nextFloat();
        int size = scanner.nextInt();
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextFloat();
        }
        quickSort(array, 0, size - 1);
        boolean[] check = new boolean[size];
        for (int i = 0; i < array.length; i++) {
            checkNumber(array, check, i, n);
        }
    }


    private static void checkNumber(float[] array, boolean[] check, int i, float n) {
        if (!check[i]) {
            float temp = n - array[i];
            int index = binarySearch(array, check, 0, array.length - 1, temp);
            if (index != -1) {
                System.out.println(array[i] + " + " + array[index]);
                check[i] = true;
                check[index] = true;
            }
        }
    }


    static int binarySearch(float array[], boolean[] check, int left, int right, float temp) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (array[mid] == temp && !check[mid])
                return mid;

            if (array[mid] > temp)
                return binarySearch(array, check, left, mid - 1, temp);


            return binarySearch(array, check, mid + 1, right, temp);
        }

        return -1;
    }

    static int partition(float arr[], int first, int last) {
        float pivot = arr[last];
        int i = (first - 1);
        for (int j = first; j < last; j++) {
            if (arr[j] < pivot) {
                i++;

                float temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        float temp = arr[i + 1];
        arr[i + 1] = arr[last];
        arr[last] = temp;

        return i + 1;
    }


    static void quickSort(float array[], int first, int last) {
        if (first < last) {
            int pi = partition(array, first, last);
            quickSort(array, first, pi - 1);
            quickSort(array, pi + 1, last);
        }
    }

}
