package recursion;

import java.util.ArrayList;

public class recursion_allIndices {
    static ArrayList<Integer> indices = new ArrayList<Integer>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 5, 6, 7, 5, 8, 10, 9, 5};
        System.out.println(allIndices(arr, 5, 0));
    }

    public static ArrayList allIndices(int[] array, int element, int startIndex) {
        if (startIndex > array.length - 1) {
            return null;
        }
        if (array[startIndex] == element) {
            indices.add(startIndex);
        }
        allIndices(array, element, startIndex + 1);
        return indices;
    }
}
