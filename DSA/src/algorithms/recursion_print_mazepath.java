package algorithms;

import java.awt.*;

public class recursion_print_mazepath {
    public static void main(String[] args) {
        printMazepath(0, 0, 2, 2, "");
    }

    public static void printMazepath(int sr, int sc, int er, int ec, String result) {
        if (sr == er && sc == ec) {
            System.out.println(result);
            return;
        }

        if (sr > er || sc > ec) {
            return;
        }
        //Horizontal Move
        printMazepath(sr, sc + 1, er, ec, "H" + result);

        //Vertical Move
        printMazepath(sr + 1, sc, er, ec, "V" + result);

    }
}
