package leetcode.editor.en;// 2022-07-02 13:54:36


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution678 {
    public boolean checkValidString(String s) {

        Stack<Integer> open = new Stack<>(); // (
        Stack<Integer> star = new Stack<>(); // *

        // traverse and balance )
        for (int i = 0; i < s.length(); i++) {
            // (
            if (s.charAt(i) == '(')
                open.push(i);

                // *
            else if (s.charAt(i) == '*')
                star.push(i);

                // )
            else {
                // balance with (
                if (!open.isEmpty())
                    open.pop();
                    // balance with * = (
                else if (!star.isEmpty())
                    star.pop();
                    // cannot balance
                else
                    return false;
            }
        }

        // balancing left out (
        while (!open.isEmpty() && !star.isEmpty()) {
            // balance with *
            if (open.peek() < star.peek()) {
                open.pop();
                star.pop();
            } else
                return false;
        }

        return open.isEmpty(); // make sure all ( balanced
    }
}
//leetcode submit region end(Prohibit modification and deletion)
