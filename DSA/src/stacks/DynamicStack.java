package stacks;

public class DynamicStack extends Stack {

    public DynamicStack(int capacity){
        super(capacity);
    }

    public void push(int element){
        // When the array is full
        if(this.size() == this.array.length) {
            // Create a new array of double length
            int[] array2 = new int[2 * this.array.length];

            // And copy the elements to new array
            System.arraycopy(this.array, 0, array2, 0, array.length);

            // Point the reference of original array to new array
            // Hence garbage remover removes old array
            array = array2;
        }
        // Push will work same as before with the new array
        // Of Course until its full again
        super.push(element);
    }
}

class test2 {
    public static void main(String[] args) {
        DynamicStack s = new DynamicStack(3);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        s.show();

    }
}