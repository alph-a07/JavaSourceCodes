package problems;

import java.util.HashMap;

// Question : Check whether given array contains any sub-array whose sum is 0.
public class DoesSubarrayWithSum0Exist {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 2, 3, 4};
        int[] arr2 = new int[]{0, 1, 2, -3, 4};
        System.out.println(fun(arr1));
        System.out.println(fun(arr2));
    }

    // APPROACH
    // p[i] = sum(0,i)
    // Sum of any sub-array between ith and jth index
    // sum(i,j) = p[j] - p[i] + arr[i]
    // sum(i+1,j) = p[j] - p[i]
    // Hence return true if any two elements are same in prefixSum array

    // O(N)                                                -- one array traversal
    public static boolean fun(int[] arr) {

        int prefixSum = 0;

        // Value is meaningless for us
        // Put keys in the map if they already don't exist
        // Otherwise return true(already exists)
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            prefixSum += arr[i];
            if (!map.containsKey(prefixSum) && prefixSum != 0) {
                map.put(prefixSum, true);
            } else {
                return true;
            }
        }
        return false;
    }
}
