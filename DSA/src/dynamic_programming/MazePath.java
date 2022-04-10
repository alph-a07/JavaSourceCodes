package dynamic_programming;

// Given a 2D board, find number of ways to reach (endRow,endColumn) from starting point. [Only positive(+1) horizontal and vertical moves allowed]
public class MazePath {

    public static void main(String[] args) {
        int N = 4;
        System.out.println(recursive(0, 0, N, N));
        System.out.println(topDown(0, 0, N, N, new int[N + 1][N + 1]));
        System.out.println(bottomUp(0, 0, N, N));
        System.out.println(bottomUpSE(0, 0, N, N));
    }

    // Time complexity = O(2^(er*ec)))
    // Space complexity = O(1) + R.S
    public static int recursive(int cr, int cc, int er, int ec) {
        // +ve base case
        if (cr == er && cc == ec)
            return 1;

        // -ve base case
        if (cr > er || cc > ec)
            return 0;

        // smaller problems
        int horizontal = recursive(cr, cc + 1, er, ec);
        int vertical = recursive(cr + 1, cc, er, ec);

        return horizontal + vertical; // self work
    }

    // Time complexity = O(er*ec)
    // Space complexity = O(er*ec) + R.S
    public static int topDown(int cr, int cc, int er, int ec, int[][] storage) {
        // +ve base case
        if (cr == er && cc == ec)
            return 1;

        // -ve base case
        if (cr > er || cc > ec)
            return 0;

        // reuse
        if (storage[cr][cc] != 0)
            return storage[cr][cc];

        // smaller problems
        int horizontal = topDown(cr, cc + 1, er, ec, storage);
        int vertical = topDown(cr + 1, cc, er, ec, storage);

        storage[cr][cc] = horizontal + vertical; // store

        return horizontal + vertical; // self work
    }

    // Time complexity = O(er*ec)
    // Space complexity = O(er*ec)
    public static int bottomUp(int cr, int cc, int er, int ec) {
        int[][] storage = new int[er + 2][ec + 2];

        for (int i = er; i >= 0; i--) {
            for (int j = ec; j >= 0; j--) {
                if (i == er && j == ec)
                    storage[i][j] = 1; // +ve base case
                else
                    storage[i][j] = storage[i + 1][j] + storage[i][j + 1];
            }
        }

        return storage[0][0];
    }

    // Time complexity = O(er*ec)
    // Space complexity = O(ec)
    public static int bottomUpSE(int cr, int cc, int er, int ec) {
        int[] storage = new int[ec + 1]; // 1D storage array

        for (int i = 0; i <= ec; i++)
            storage[i] = 1;

        // num of slides = er
        for (int slide = er - 1; slide >= 0; slide--) {
            for (int i = ec - 1; i >= 0; i--) {
                storage[i] += storage[i + 1]; // below element + right element
            }
        }
        return storage[0];
    }
}
