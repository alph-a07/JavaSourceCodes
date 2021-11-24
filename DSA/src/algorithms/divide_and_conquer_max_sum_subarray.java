package algorithms;

public class divide_and_conquer_max_sum_subarray {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 5, 7};
        System.out.println(maxsum_subarray(array, 0, array.length - 1));
    }

    //Checks for maximum subarray which contains mid element also
    public static int midcrossmax_sum_subarray(int[] array, int mid, int low, int high) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum = sum + array[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum += array[i];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }
        return Math.max(Math.max(left_sum, right_sum), left_sum + right_sum);
    }

    //checks for maximum between right and left subarray ans the subarray containing mid element
    public static int maxsum_subarray(int[] array, int low, int high) {
        if (low == high)
            return array[low];
        int mid = (low + high) / 2;

        return Math.max(Math.max(maxsum_subarray(array, low, mid), maxsum_subarray(array, mid + 1, high)),
                midcrossmax_sum_subarray(array, mid, low, high));
    }
}
