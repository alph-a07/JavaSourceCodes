public class recursion_factorial {
    static int count = 1;

    public static void main(String[] args) {
        System.out.println(findFactorial(0));
        System.out.println(findFactorial(1));
        System.out.println(findFactorial(5));
        System.out.println(findFactorial(-1));
    }

    public static int findFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            System.out.print("Invalid ");
            return -1;
        }
        count *= n;
        findFactorial(n - 1);
        return count;
    }
}
