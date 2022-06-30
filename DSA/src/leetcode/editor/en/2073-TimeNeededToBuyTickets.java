package leetcode.editor.en;// 2022-06-28 15:13:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int counter = 0;

        // count till kth person buys k tickets
        while (tickets[k] != 0) {

            // if current person has to buy a ticket
            if (tickets[counter] != 0) {
                tickets[counter]--; // ticket bought
                time++; // 1 sec increased
            }
            counter = (counter + 1) % tickets.length; // rotate through array
        }
        return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
