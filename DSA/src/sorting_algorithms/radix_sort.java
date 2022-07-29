package sorting_algorithms;

public class radix_sort {

    public static int[] radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int a : arr)
            max = Math.max(a, max);

        int radix = 1;
        // count sort for each digit
        while (max / radix > 0) {
            countSort(arr, radix);
            radix *= 10;
        }
        return arr;
    }

    private static void countSort(int[] arr, int radix) {

        int[] count = new int[10]; //  0 - 9

        // counting
        for (int a : arr)
            count[(a / radix) % 10]++;

        // finding count of each element w.r.t elements before
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[arr.length];

        // inserting elements at their counted index
        for (int i = arr.length - 1; i >= 0; i--) {
            res[--(count[(arr[i] / radix) % 10])] = arr[i];
        }

        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] res = radixSort(new int[]{4, 0, 0, 1, 0, 2, 4, 5, 1});

        for (int i : res)
            System.out.println(i);
    }
}


