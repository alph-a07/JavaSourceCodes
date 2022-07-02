package leetcode.editor.en;// 2022-07-02 14:54:09

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        solution(s, minRemoval(s), ans, new HashSet<>());

        return ans;
    }

    // returns minimum removals required
    private int minRemoval(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i)); // push (

            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop(); // balance ) if possible
                else
                    stack.push(s.charAt(i)); // else push ) too
            }

        }
        return stack.size(); // non-balanced
    }

    // 💡 Set is must for time optimisation so that we don't process same string multiple times
    private void solution(String s, int minRemovalAllowed, List<String> ans, HashSet<String> set) {

        // to avoid repeated processing
        if (set.contains(s))
            return;
        set.add(s);

        // BASE CASE
        if (minRemovalAllowed == 0) {
            // validity check
            if (minRemoval(s) == 0) {
                ans.add(s);
            }
            return;
        }

        // remove each bracket until minRemovalAllowed == 0
        for (int i = 0; i < s.length(); i++) {

            // avoid letters
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                continue;

            // removing current element
            String left = s.substring(0, i);
            String right = s.substring(i + 1);

            if (!set.contains(left + right)) // optimisation
                solution(left + right, minRemovalAllowed - 1, ans, set);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
