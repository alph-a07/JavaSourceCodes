package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";

        String first = strs[0]; // first string to use as base

        // loop on first string characters
        for (int i = 0; i < first.length(); i++) {

            ans = ans + first.charAt(i); // add current character to answer

            // loop on other strings
            for (int j = 1; j < strs.length; j++) {

                // check if other strings have same character at ith index
                if (i < strs[j].length() && strs[j].charAt(i) == first.charAt(i))
                    continue; // answer is fine

                // different character at ith index
                else
                    return ans.substring(0, i); // ignore last character of answer and return
            }
        }
        return ans;
    }
}
