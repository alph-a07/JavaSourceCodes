package leetcode.editor.en;// 2022-07-12 15:07:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution121 {
    public int maxProfit(int[] prices) {
        int leastBuy = Integer.MAX_VALUE;
        int tempProfit = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            leastBuy = Math.min(prices[i], leastBuy); // updating cheaper buy
            tempProfit = prices[i] - leastBuy; // if sold today
            profit = Math.max(tempProfit, profit); // maximising profit
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
