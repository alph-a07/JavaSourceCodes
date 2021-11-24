package algorithms;

public class merge_sort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 4, 1, 9, 10, 3, 8, 4};
        int[] ans = mergeSort(array, 0, array.length - 1);

        for (int value : ans) {
            System.out.print(value + " ");
        }
    }

    public static int[] mergeSort(int[] array, int low, int high) {
        //Positive Base case
        //When the half arrays are completely divided ans contains only a single element
        if (low == high) {
            int[] baseresult = new int[1];
            baseresult[0] = array[low];
            return baseresult;
        }
        int mid = (low + high) / 2;

        //Assuming that recursion works for half array already
        int[] fh = mergeSort(array, low, mid);
        int[] sh = mergeSort(array, mid + 1, high);
        //Divided until size 1--means sorted
        //So merge2array merges two sorted arrays and returns the result to upper half arrays
        return merge2array(fh, sh);
    }

    public static int[] merge2array(int[] array1, int[] array2) {
        //Both are sorted already

        int[] result = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        //Ascending order
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k] = array1[i];
                i++;
                k++;
            } else {
                result[k] = array2[j];
                j++;
                k++;
            }
        }

        //When one of the array is whole checked and exhausted
        if (i == array1.length) {
            while (j < array2.length) {
                result[k] = array2[j];
                j++;
                k++;
            }
        }
        if (j == array2.length) {
            while (i < array1.length) {
                result[k] = array1[i];
                i++;
                k++;
            }
        }
        return result;
    }
}
