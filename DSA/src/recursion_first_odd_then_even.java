public class recursion_first_odd_then_even {
    public static void main(String[] args) {
        odd_even(5);
    }

    public static void odd_even(int n) {
        if (n == 0)
            return;
        if (n % 2 == 1)
            System.out.println(n);          //if odd print otherwise call next
        odd_even(n - 1);
        if (n % 2 == 0)
            System.out.println(n);          //prints the remaining even
    }
}
