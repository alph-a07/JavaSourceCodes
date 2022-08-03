package leetcode.editor.en;// 2022-07-12 15:07:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution121 {
    public int maxProfit(int[] prices) {
        int leastBuy = Integer.MAX_VALUE;
        int tempProfit;
        int profit = 0;

        // as bought once can be sold after only, one pass is sufficient
        for (int price : prices) {
            leastBuy = Math.min(price, leastBuy); // updating cheaper buy
            tempProfit = price - leastBuy; // if sold today
            profit = Math.max(tempProfit, profit); // maximising profit
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
