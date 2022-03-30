package leetcode;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp1 = 0;
        int temp2 = 0;

        while (temp1 < m + n && temp2 < n) {
            if (temp1 >= m && nums1[temp1] == 0) {
                nums1[temp1] = nums2[temp2];
                temp1++;
                temp2++;
            }
            if (temp1 < m + n && temp2 < n && nums1[temp1] <= nums2[temp2] && nums1[temp1] != 0)
                temp1++;

            if (temp1 < m + n && temp2 < n && nums1[temp1] > nums2[temp2] && nums1[temp1] != 0) {
                for (int k = temp1; k < m; k++) {
                    nums1[k + 1] = nums1[k];
                }
                nums1[temp1] = nums2[temp2];
                temp1++;
                temp2++;
            }
        }
    }
}
