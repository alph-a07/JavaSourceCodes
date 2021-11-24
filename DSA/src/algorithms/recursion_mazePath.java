package algorithms;

import java.util.ArrayList;

public class recursion_mazePath {
    public static void main(String[] args) {
        System.out.println(mazePath(0, 0, 2, 2));
    }

    //RECURSION CONCEPT 101
    //Always find the smaller problem first
    //(1)--Start by moving to the most adjacent solution available, Don't think too far
    //(2)--Always assume the recursion works and the perform whatever else is necessary
    public static ArrayList mazePath(int SR, int SC, int ER, int EC) {
        //Positive Base Case
        if (SR == ER && SC == EC) {
            ArrayList<String> baseresult = new ArrayList<>();
            baseresult.add("");
            return baseresult;
        }

        //Negative Base Case
        if (SR > ER || SC > EC) {
            ArrayList<String> nullList = new ArrayList<>();
            return nullList;
        }

        ArrayList<String> result = new ArrayList<>();

        //Move one step horizontal
        ArrayList<String> horizontal_recursion_result = mazePath(SR, SC + 1, ER, EC);
        for (String value : horizontal_recursion_result) {
            result.add("H" + value);                     //Just assume it works already
        }

        //Move one stp vertical
        ArrayList<String> vertical_recursion_result = mazePath(SR + 1, SC, ER, EC);
        for (String value : vertical_recursion_result) {
            result.add("V" + value);                     //Just assume it works already
        }
        return result;
    }
}
