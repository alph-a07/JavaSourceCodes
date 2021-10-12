public class recursion_pattern {
    public static void main(String[] args) {
        pattern(7, 1, 1);
    }

    public static void pattern(int n, int row, int column) {
        if (row > n)
            return;
        if (column > row) {                           //As Number of * = Row Number
            System.out.println();                     //When number of column becomes more than * go to next line
            pattern(n, row + 1, 1);
            //Call the function for column 1 only as column will increase as it should by function definition below
            return;
        }
        System.out.print("*");                        //Print *
        pattern(n, row, column + 1);           //Move Right

    }
}