package problems;

import java.util.*;

public class lower_upper_bounds {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 9, 1, 2, 4, 9, 2, 7, 4};
        //sorting array
        Arrays.sort(arr);
        //sort modifies the original array itself
        for (int j : arr) {
            System.out.print(j + ",");
        }
        System.out.println("\n");
        System.out.println(lowerBound(arr, 2, 0, arr.length));
        System.out.println(upperBound(arr, 2, 0, arr.length));
    }
    //CONCEPT :
    //Calling the function recursively until high and low crosses for both left and right subarray

    public static int lowerBound(int[] arr, int element, int low, int high) {
        //This is the base case which will be always false initially
        //But will eventually be true as recursion proceeds
        if (low > high)
            return low;
        int mid = (low + high) / 2;         //middle element

        //If entered element is larger than mid-element then checking left subarray
        if (element <= arr[mid]) {
            return lowerBound(arr, element, low, mid - 1);
        }
        //Don't insert 'else' as it will eat up the return statement of function
        return lowerBound(arr, element, mid + 1, high);           //checking right subarray
    }

    public static int upperBound(int[] arr, int element, int low, int high) {
        if (low > high)
            return low;
        int mid = (low + high) / 2;
        if (element >= arr[mid]) {                                    //checking right subarray
            return upperBound(arr, element, mid + 1, high);
        }
        return upperBound(arr, element, low, mid - 1);             //checking left subarray
    }
}
