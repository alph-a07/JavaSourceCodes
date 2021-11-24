package algorithms;

public class power_program_of_logn_TC {
    public static void main(String[] args) {
        System.out.println(power(2, 4));
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int recursion_ans = power(x, n / 2);
        if (n % 2 == 1) {
            return recursion_ans * recursion_ans * x;
        } else {
            return recursion_ans * recursion_ans;
        }
    }
}
