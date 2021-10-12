public class Coinchange {
    public static void main(String[] args) {
        int[] denom = new int[]{2, 3, 5, 6};    //coins
        coinchange(denom, 10, "", 0);
    }

    public static void coinchange(int[] denom, int amount, String ans, int last_denom) {
        if (amount == 0) {
            System.out.println(ans);
            return;
        }

        //i starts from last_denom to avoid repeated permutations
        for (int i = last_denom; i < denom.length; i++) {
            //amount should not be less than coin available
            if (amount >= denom[i])
                coinchange(denom, amount - denom[i], ans + denom[i], i);
        }
    }
}
