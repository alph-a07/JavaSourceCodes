public class backtracking_queens_permutations {
    public static int count = 0;

    public static void main(String[] args) {
        boolean[] boxes = new boolean[4];
        permutations(boxes, 0, 2, "");
    }

    //qpsf --> queens placed so far
    //tq --> total queens
    public static void permutations(boolean[] boxes, int qpsf, int tq, String ans) {
        //when all queens are placed print ans
        if (qpsf == tq) {
            count++;
            System.out.println(count + "." + ans);
            return;
        }
        //start putting q0 from 0 to n-1
        for (int i = 0; i < boxes.length; i++) {
            //checking where q0 can be put
            //true-->occupied     false-->empty
            if (boxes[i] == false) {
                boxes[i] = true;          //if the place is available then put q0
                permutations(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
                //checking availability for q1 same way --> recursive call
                boxes[i] = false; //undo ---backtracking
            }
        }
    }
}

