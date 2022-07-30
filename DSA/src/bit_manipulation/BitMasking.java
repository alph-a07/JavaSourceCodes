package bit_manipulation;

public class BitMasking {
    public static void main(String[] args) {

    }

    // ith bit of an integer a (LSB to MSB)
    static int ithbit(int a, int i) {
        int mask = 1 << i; // left shift 1 by i bits (to the ith bit)

        // ith bit = if (a & mask == 1) 1 else 0
        return a & mask;
    }

    // set => set to 1 (by default)
    static int setithBit(int a, int i) {
        int mask = 1 << i; // 1 shifted left by i bits

        return a | mask; // will set ith bit
    }

    static int clearithBit(int a, int i) {
        int mask = ~(1 << i); // 0 shifted left by i bits (other bits 1)

        return a & mask; // will clear ith bit
    }

    static int differentBits(int a, int b) {
        int t = a ^ b; // XOR will set bits in t where a and b have different bits

        // our answer is the number of set bits in t
        int res = 0;
        /*
        // right shift and increase counter if LSB is 1
        // Time complexity = log(n) i.e. total number of bits
        while (t != 0) {
            if ((t & 1) == 1)
                res++;

            t = t >> 1;
        }*/

        // Time complexity = number of set bits ⬇️
        // 💡 Finding number of set bits
        while (t != 0) {
            t = t & (t - 1); // clears the least significant set bit
            res++;
        }
        return res;
    }
}
