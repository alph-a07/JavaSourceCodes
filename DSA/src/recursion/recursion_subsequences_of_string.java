package recursion;

import java.util.ArrayList;

public class recursion_subsequences_of_string {
    public static void main(String[] args) {
        System.out.println(subsequences("abcd"));
    }

    public static ArrayList subsequences(String s) {
        if (s == "") {
            ArrayList<String> baseResult = new ArrayList<String>();   //Just to match the return type
            baseResult.add("");
            return baseResult;   //So that recursive_result can add a null string as a subsequence
        }
        char c = s.charAt(0);                                         //getting first character
        String SminusC = s.substring(1);                              //String after removing first character
        ArrayList<String> result = new ArrayList<String>();           //final result
        ArrayList<String> recursion_result = subsequences(SminusC);   //To store result for each recursive iteration
        //recursion_result will call the recursive function with modified string value each time
        //until it becomes null

        //Here's the main approach
        //Remove a character and find subsequences of the remaining string
        //Then add the removed character to those subsequences
        for (int i = 0; i < recursion_result.size(); i++) {
            result.add(recursion_result.get(i));
            result.add(c + recursion_result.get(i));
        }
        return result;
    }
}
