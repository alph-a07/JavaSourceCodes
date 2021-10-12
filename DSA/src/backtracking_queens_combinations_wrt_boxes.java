public class backtracking_queens_combinations_wrt_boxes {
    static int count = 1;

    public static void main(String[] args) {
        combinations(new boolean[4], 0, 2, 0, "");
    }

    public static void combinations(boolean[] boxes, int qpsf, int tq, int i, String ans) {
        if (qpsf == tq) {
            System.out.println(count + "." + ans);
            count++;
            return;
        }

        if (i == boxes.length) {
            return;
        }
        boxes[i] = true;
        combinations(boxes, qpsf + 1, tq, i + 1, ans + "b" + i);
        boxes[i] = false;
        combinations(boxes, qpsf, tq, i + 1, ans + "");
    }
}
