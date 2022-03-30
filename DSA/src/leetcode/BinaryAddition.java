package leetcode;

import java.util.HashMap;

public class BinaryAddition {
    public String addBinary(String a, String b) {
        int length = Math.min(a.length(), b.length());
        String ans = "";
        HashMap<Integer, Character> map = new HashMap<>();
        char carry = binarySum(a.charAt(length - 1), b.charAt(length - 1), '0', ans);
        map.put(length - 1, carry);
        for (int i = length - 2; i >= 0; i--) {
            map.put(i, binarySum(a.charAt(i), b.charAt(i), map.get(i + 1), ans));
        }

        return ans;
    }

    public char binarySum(char a, char b, char carry, String s) {
        if (carry == '0') {
            if (a == '1' && b == '1') {
                s = "0" + s;
                return '1';
            } else if ((a == '1' && b == '0') || (a == '0' && b == '1')) {
                s = "1" + s;
                return '0';
            } else {
                s = "0" + s;
                return '0';
            }
        } else {
            if (a == '1' && b == '1') {
                s = "1" + s;
                return '1';
            } else if ((a == '1' && b == '0') || (a == '0' && b == '1')) {
                s = "0" + s;
                return '1';
            } else {
                s = "1" + s;
                return '0';
            }
        }
    }
}
