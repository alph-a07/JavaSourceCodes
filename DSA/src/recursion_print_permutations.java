public class recursion_print_permutations {
    public static void main(String[] args) {
        printPermutations("abc", "");
    }

    public static void printPermutations(String s, String result) {
        if (s.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String SminusC = s.substring(0, i) + s.substring(i + 1);         //Removing ith element from string
            printPermutations(SminusC, result + c);
            //This will add c to all positions possible as it is performed in the loop
        }
    }
}

