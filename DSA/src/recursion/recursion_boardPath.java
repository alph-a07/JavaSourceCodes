package recursion;

import java.util.ArrayList;

public class recursion_boardPath {
    public static void main(String[] args) {
      /*  System.out.println(boardPath(0, 10));
        //OUTPUT WILL BE AN ARRAYLIST OF SIZE 492*/
        System.out.println("For end = 1");
        System.out.println(boardPath(0, 1));
        System.out.println("For end = 2");
        System.out.println(boardPath(0, 2));
        System.out.println("For end = 3");
        System.out.println(boardPath(0, 3));
        System.out.println("For end = 4");
        System.out.println(boardPath(0, 4));
    }

    //CONCEPT
    //Starting the program we have nothing so current = 0
    //We will break the program in smaller problems instead of directly reaching from 0 to 10
    /*For example we will find ways to reach 10 from 4 and then add 4 to all of them which will give us ways to reach
    10 from 0*/
    public static ArrayList boardPath(int current, int end) {

        //Returning empty string for the previous recursive call to take as input
        if (current == end) {
            ArrayList<String> baseresult = new ArrayList<>();
            baseresult.add("");
            return baseresult;
        }

        //Returning null list such that result is not interfered
        if (current > end) {
            ArrayList<String> nullList = new ArrayList<>();
            return nullList;
        }

        ArrayList<String> result = new ArrayList<>();
        for (int dice = 1; dice <= 6; dice++) {
            ArrayList<String> recursion_result = boardPath(current + dice, end);   //Assumed works already
            //Recursive call for setting current value [1 to 6]
            for (String value : recursion_result) {
                result.add(dice + value);
            }
        }
        return result;
    }
}
