public class recursion_nth_fibonacci_term {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
