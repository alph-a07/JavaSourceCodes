package dynamic_programming;

// Given a 2D board, find number of ways to reach (endRow,endColumn) from starting point. [Only positive(+1) horizontal, vertical and diagonal moves allowed]
public class MazePathDiagonal {
    public static void main(String[] args) {
        int N = 2;
        System.out.println(recursive(0, 0, N, N));
        System.out.println(topDown(0, 0, N, N, new int[N + 1][N + 1]));
        System.out.println(bottomUp(0, 0, N, N));
        System.out.println(bottomUpSE(0, 0, N, N));
    }

    // Time complexity = O(3^(er*ec)))
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
        int diagonal = recursive(cr + 1, cc + 1, er, ec);

        return horizontal + vertical + diagonal; // self work
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
        int diagonal = topDown(cr + 1, cc + 1, er, ec, storage);

        storage[cr][cc] = horizontal + vertical + diagonal; // store

        return horizontal + vertical + diagonal; // self work
    }

    // Time complexity = O(er*ec)
    // Space complexity = O(er*ec)
    public static int bottomUp(int cr, int cc, int er, int ec) {
        int[][] storage = new int[er + 1][ec + 1]; // avoiding making one extra size storage

        // filling 1s in last column
        for (int row = 0; row <= er; row++)
            storage[row][ec] = 1;

        // filling 1s in last row
        for (int column = 0; column <= ec; column++)
            storage[er][column] = 1;

        for (int i = er - 1; i >= 0; i--) {
            for (int j = ec - 1; j >= 0; j--) {
                if (i == er && j == ec)
                    storage[i][j] = 1; // +ve base case
                else
                    storage[i][j] = storage[i + 1][j] + storage[i][j + 1] + storage[i + 1][j + 1];
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

        int diag = 0;

        // num of slides = er
        for (int slide = er - 1; slide >= 0; slide--) {
            for (int i = ec; i >= 0; i--) {
                if (i == ec) {
                    storage[i] = 1;
                    diag = 1; // diagonal for next element
                } else {
                    int temp = storage[i] + storage[i + 1] + diag;
                    diag = storage[i]; // diagonal for next element
                    storage[i] = temp; // below element + right element
                }

            }
        }
        return storage[0];
    }
}
