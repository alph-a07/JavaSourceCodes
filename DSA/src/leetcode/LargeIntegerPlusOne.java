package leetcode;

public class LargeIntegerPlusOne {
    public int[] plusOne(int[] digits) {
        int counter = 0;
        for (int i : digits) {
            if (i == 9)
                counter++;
        }

        if (counter == digits.length) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;

            return arr;
        } else {
            long num = 0;
            for (int i = 0; i < digits.length; i++) {
                num += digits[i] * Math.pow(10, digits.length - i - 1);
            }
            num = num + 1;

            int[] arr;
            arr = new int[digits.length];

            int j = arr.length - 1;
            while (j >= 0) {
                int digit = (int) (num % 10);
                arr[j] = digit;
                num = num / 10;
                j--;
            }
            return arr;
        }
    }
}
