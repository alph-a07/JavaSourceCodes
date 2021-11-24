package algorithms;

import java.util.ArrayList;

public class recursion_permutations {
    public static void main(String[] args) {
        System.out.println(getPermutations("abc"));
    }

    //CONCEPT
    //Remove first character and then add it to all possible places in the remaining string
    public static ArrayList getPermutations(String s) {
        if (s.length() == 0) {
            ArrayList<String> baseresult = new ArrayList<>();
            baseresult.add("");
            return baseresult;
            //It will be returned to getPermutations(c) to add c to a blank string
            //While the stack will be falling
        }
        char c = s.charAt(0);
        String SminusC = s.substring(1);
        ArrayList<String> recursion_result = getPermutations(SminusC); //Assumed that function works already
        ArrayList<String> result = new ArrayList<>();

        for (String value : recursion_result) {
            for (int j = 0; j <= value.length(); j++) {
                String val = value.substring(0, j) + c + value.substring(j);
                //substring(0,j) excludes jth index
                //substring(j) includes jth index
                //Hence the character is inserted at every position using j for loop
                result.add(val);
            }
        }
        return result;
    }

}
