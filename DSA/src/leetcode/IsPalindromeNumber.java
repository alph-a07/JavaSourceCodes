package leetcode;

public class IsPalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int temp = x;
        int remainder;
        int reverse = 0;

        while (temp != 0) {
            remainder = temp % 10;
            reverse = reverse * 10 + remainder; // right digits are shifted to left [that's why reverse *= 10]
            temp /= 10;
        }

        return x - reverse == 0; // true if number and its reverse are same
    }
}
