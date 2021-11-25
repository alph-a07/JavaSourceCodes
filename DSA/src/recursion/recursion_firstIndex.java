package recursion;

import java.util.Arrays;

public class recursion_firstIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 5, 6, 7, 5, 8, 10, 9, 5};
        System.out.println(firstIndex(arr, 5, 0));
    }

    public static int firstIndex(int[] array, int element, int startIndex) {
        //If the element is found then the if else block will be evaluated
        //But we'll reach at the end of the array finding the element if it does not exist
        //Base Case
        if (startIndex == array.length - 1)
            return -1;
        if (array[startIndex] == element) {
            return startIndex;
        } else {
            return firstIndex(array, element, startIndex + 1);
        }
    }
}
