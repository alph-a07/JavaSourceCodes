package bit_manipulation;

public class SingleNumberInThriceRepetition {
    static int singleNumber(int[] arr) {
        int[] bitCount = new int[32]; // 32-bit integer

        // for each bit
        for (int i = 0; i < bitCount.length; i++) {
            // for each number
            for (int k : arr) {
                if ((k & (1 << i)) != 0) // ith  bit
                    bitCount[i]++;
            }
        }

        int res = 0;
        // traversing bit count array
        for (int i = 0; i < bitCount.length; i++) {
            bitCount[i] = bitCount[i] / 3 == 0 ? 0 : bitCount[i] % 3; // set bits which are not multiple of 3 (unique)
            res += Math.pow(2, i) * bitCount[i]; // compute unique number along with
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 1, 2, 1, 2, 4, 4, 4, 5, 3, 3}));
    }
}
