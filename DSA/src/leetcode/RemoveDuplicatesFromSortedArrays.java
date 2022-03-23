package leetcode;

public class RemoveDuplicatesFromSortedArrays {
    // IN-PLACE
    public int removeDuplicates(int[] nums) {
        int k = 1; // Effective number of elements in answer array

        // loop on whole array
        for (int i = 0; i < nums.length - 1; i++) {
            // loop on next elements of current element
            for (int j = i + 1; j < nums.length; j++) {
                // If any number less than current element is found, put it next to current element
                if (nums[i] != nums[j] && nums[i] < nums[j]) {
                    nums[i + 1] = nums[j];
                    break;
                }
            }
        }
        // Duplicated elements will be gathered at the end of array

        for (int i = 0; i < nums.length - 1; i++) {
            // loop will break when max element will be reached
            if (nums[i] < nums[i + 1])
                k++;
            else
                break;
        }

        return k;
    }
}
