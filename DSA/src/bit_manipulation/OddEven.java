package bit_manipulation;

public class OddEven {
    public static void main(String[] args) {
        System.out.println(isEven(1));
        System.out.println(isEven(2));
        System.out.println(isEven(0));
    }

    static boolean isEven(int a) {
        return (a & 1) == 0;
    }
}
