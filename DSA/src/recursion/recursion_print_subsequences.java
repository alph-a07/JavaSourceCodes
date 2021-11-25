package recursion;

public class recursion_print_subsequences {
    public static void main(String[] args) {
        printSubsequences("abc","");
    }

    public static void printSubsequences(String s, String result) {
        if (s.length() == 0) {
            System.out.println(result);
            return;
        }
        char c = s.charAt(0);
        String SminusC = s.substring(1);
        printSubsequences(SminusC, result);
        //This will decrease length of SminusC but won't print anything as result is empty at the beginning
        //So at the end of this recursive call the base case will be satisfied
        //But still nothing will be printed
        printSubsequences(SminusC, result + c);
        //This call is made when String s is empty
        //So base case will print the result this time adding the removed character
    }
}
