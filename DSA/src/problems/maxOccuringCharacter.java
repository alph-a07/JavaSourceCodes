package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class maxOccuringCharacter {
    public static void main(String[] args) {
        System.out.println(getMaxFreqChar("wrfvcndjcnwjdxkdww"));
    }

    // TIME COMPLEXITY => O(N)
    public static char getMaxFreqChar(String string) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if (!map.containsKey(currentChar))
                map.put(currentChar, 1);
            else
                map.put(currentChar, map.get(currentChar) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();

        char maxChar = '\0';
        int max = 0;

        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }
}
