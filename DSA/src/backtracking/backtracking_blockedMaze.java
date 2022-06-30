package backtracking;

public class backtracking_blockedMaze {
    public static void main(String[] args) {
        int[][] maze = new int[4][4];
        maze[0][1] = 1;
        maze[2][1] = 1;
        maze[3][2] = 1;

        blockedmaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
    }

    public static void blockedmaze(int[][] maze, int row, int column, String ans, boolean[][] visited) {
        // positive base case
        if (row == maze.length - 1 && column == maze.length) {
            System.out.println(ans);
            return;
        }

        // negative base case
        if (row < 0 || row >= maze.length ||                                  // out of boundary
                column < 0 || column >= maze[row].length ||                 // out of boundary
                visited[row][column] ||                                     // already visited
                maze[row][column] == 1) {                                   // blocked
            return;
        }

        visited[row][column] = true;

        // Top
        blockedmaze(maze, row - 1, column, ans + "T", visited);
        // Down
        blockedmaze(maze, row + 1, column, ans + "D", visited);
        // Left
        blockedmaze(maze, row, column - 1, ans + "L", visited);
        // Right
        blockedmaze(maze, row, column + 1, ans + "R", visited);

        visited[row][column] = false;                         // backtracking
    }
}
