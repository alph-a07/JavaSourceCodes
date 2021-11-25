package recursion;

public class recursion_print_boardpath {
    public static void main(String[] args) {
        printBoardpath(0, 10, "");
    }

    public static void printBoardpath(int current, int end, String result) {
        if (current == end) {
            System.out.println(result);
            return;
        }

        if (current > end) {
            return;
        }

        for (int dice = 1; dice <= 6; dice++) {
            printBoardpath(current + dice, end, dice + result);
        }
    }
}
