package bit_manipulation;

public class TwoUniqueNumbersINTwiceRepetition {
    static int[] twoUniqueNumbers(int[] arr) {
        int temp = 0;

        for (int a : arr)
            temp ^= a;

        temp = temp & -temp; // sets rightmost set bit of temp (let's say ith bit)
        // at this bit both a and b will have distinct bits
        // we will separate array in two parts
        // 1 -> ith bit is set
        // 2 -> ith bit is clear

        int a = 0;
        int b = 0;

        for (int x : arr) {
            // ith bit is clear
            if ((temp & x) == 0)
                a ^= x; // duplicates will be cancelled out to 0
                // ith bit is set
            else
                b ^= x; // duplicates will be cancelled out to 0
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] arr = twoUniqueNumbers(new int[]{1, 2, 2, 3, 4, 4, 5, 3});

        for (int a : arr)
            System.out.println(a);
    }
}
