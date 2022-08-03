package leetcode.editor.en;// 2022-08-02 19:31:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution123 {
    public int maxProfit(int[] prices) {
        // edge case
        if (prices.length == 1)
            return 0;

        int[] sellToday = new int[prices.length]; // selling compulsory
        int[] buyToday = new int[prices.length]; // buying compulsory

        int min_buy = Integer.MAX_VALUE;
        // traverse from left to right
        for (int i = 0; i < sellToday.length; i++) {
            min_buy = Math.min(min_buy, prices[i]); // min buy in past

            if (i != 0)
                sellToday[i] = Math.max(sellToday[i - 1], prices[i] - min_buy); // update profit
        }

        int max_sell = Integer.MIN_VALUE;
        // traverse from right to left
        for (int i = buyToday.length - 1; i >= 0; i--) {
            max_sell = Math.max(max_sell, prices[i]); // max sell in future

            if (i != buyToday.length - 1)
                buyToday[i] = Math.max(buyToday[i + 1], max_sell - prices[i]); // update profit
        }

        // sellToday[i] => Max profit if transaction on/before ith day
        // buyToday[i] => Max profit if transaction on/after ith day

        int total = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            total = Math.max(total, sellToday[i] + buyToday[i]);
        }

        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
