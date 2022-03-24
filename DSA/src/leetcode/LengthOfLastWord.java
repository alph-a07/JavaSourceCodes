package leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int counter = 0;

        // Traverse character array from right end
        for (int i = arr.length - 1; i >= 0; i--) {

            // space just before word found => exit loop
            if (i < arr.length - 1 && arr[i] == ' ' && arr[i + 1] != ' ')
                break;

            // spaces after word => ignore
            if (arr[i] == ' ')
                continue;
            else
                counter++; // last word
        }
        return counter;
    }
}
