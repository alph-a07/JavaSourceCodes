package bit_manipulation;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        System.out.println(a + " " + b);
        swap(a, b);
        System.out.println(a + " " + b);
    }

    static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
