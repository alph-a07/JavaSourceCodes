package backtracking;

public class backtracking_queens_combinations {
    static int count = 0;

    public static void main(String[] args) {
        combinations(new boolean[4], 0, 2, "", -1);
    }

    //CONCEPT
    //Remove permutations
    public static void combinations(boolean[] boxes, int qpsf, int tq, String ans, int lastboxUsed) {
        if (qpsf == tq) {
            count++;
            System.out.println(count + "." + ans);
            return;
        }
        for (int i = lastboxUsed + 1; i < boxes.length; i++) {
            //if block is not needed like permutations
            //As we are starting loop from next index already
            //Hence no chance of reputation
            boxes[i] = true;
            combinations(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
            boxes[i] = false;
        }
    }
}

