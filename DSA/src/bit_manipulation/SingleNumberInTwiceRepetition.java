package bit_manipulation;

public class SingleNumberInTwiceRepetition {
    static int singleNumber(int[] arr) {
        int res = 0;

        for (int a : arr) {
            res ^= a; // duplicate numbers will be converted to 0 after XOR and a ^ 0 = a
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 2, 5, 4, 4, 5, 2, 3}));
    }
}
