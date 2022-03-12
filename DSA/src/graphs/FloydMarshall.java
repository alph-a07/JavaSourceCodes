package graphs;

// O(V^3)
public class FloydMarshall {
    public static void main(String[] args) {
        // matrix of direct edge distances provided
        // 100000 => Used as infinity to stay in range
        int[][] graph = {{0, 3, 100000, 7}, {8, 0, 2, 100000}, {5, 100000, 0, 1}, {2, 100000, 1000000, 0}};

        // changes will be updated in this matrix
        int[][] distance = new int[4][4];

        // copy
        // O(V^2)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        // k - for each vertex
        // O(V^3)
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int oldClost = distance[i][j];
                    int newCost = distance[i][k] + distance[k][j];

                    if (newCost < oldClost)
                        distance[i][j] = newCost;
                }
            }
        }

        // print
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
