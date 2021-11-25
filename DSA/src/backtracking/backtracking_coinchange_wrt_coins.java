package backtracking;

public class backtracking_coinchange_wrt_coins {
    static int count = 0;

    public static void main(String[] args) {
        int[] denom = new int[]{1, 2, 3};
        coinchange(denom, 0, denom.length - 1, 4, "");
    }

    public static void coinchange(int[] denom, int low, int high, int amount, String ans) {
        if (amount == 0) {
            count++;
            System.out.println(count + "." + ans);
            return;
        }
        if (low > high) {
            return;
        }
        if (amount < 0) {
            return;
        }
        coinchange(denom, low, high, amount - denom[low], ans + denom[low]);
        coinchange(denom, low + 1, high, amount, ans);
    }

}
