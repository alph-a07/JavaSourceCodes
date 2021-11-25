package recursion;

public class recursion_power {
    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(power(2, 0));
        System.out.println(power(2, -3));
        System.out.println(power(-2, -3));
        System.out.println(power(-2, -4));
    }

    public static float power(float a, float b) {
        if (b == 0) {
            return 1;
        }
        if (b < 0) {
            float power = a * power(a, Math.abs(b) - 1);
            return 1 / power;
        }
        float power = a * power(a, b - 1);
        return power;
    }
}
