package leetcode.editor.en;// 2022-05-09 01:18:43

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class ValidParentheses {
    // VALIDITY = Brackets as in compiler code
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        // loop on charArray of brackets string
        for (char c : array) {

            // If current character is opening bracket then push to stack
            if (c == '(' || c == '{' || c == '[') stack.push(c);

                // If closing bracket found then check for its opening bracket on top of stack
            else {
                if (!stack.empty() && c == ')' && stack.pop() == '(') continue;
                else if (!stack.empty() && c == ']' && stack.pop() == '[') continue;
                else if (!stack.empty() && c == '}' && stack.pop() == '{') continue;
                else return false;
            }
        }
        return stack.empty(); // If all brackets are paired then stack will be completely empty
    }
}
//leetcode submit region end(Prohibit modification and deletion)
