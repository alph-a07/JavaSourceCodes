package leetcode;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>(); // map of roman-int data
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // traversing roman string
        while (i <= s.length() - 1) {

            // handling for last character
            if (i == s.length() - 1) {
                ans += map.get(arr[i]);
                break;
            }
            // non-last character conversion
            else {
                // For R1R2 => If R1.int < R2.int => R1R2.int = R2.int - R1.int
                if (map.get(arr[i]) < map.get(arr[i + 1])) {
                    ans += map.get(arr[i + 1]) - map.get(arr[i]);
                    i += 2; // shift by two
                }
                // Direct roman value
                else {
                    ans += map.get(arr[i]);
                    i++; // shift by one
                }
            }
        }

        return ans;
    }
}

