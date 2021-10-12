public class Stack {
    public static final int DEFAULT_CAPACITY = 5;

    int[] array;
    int top;

    public Stack() {
        this(DEFAULT_CAPACITY);
        // This keyword will call the constructor which takes one int parameter i.e capacity
    }

    // Top is the index one grater than that of upmost element
    public Stack(int capacity) {
        array = new int[capacity];
        top = 0;
    }

    // To insert an element
    public void push(int element) {
        // overflow handling
        if (size() == array.length) {
            System.out.println("Stack Overflow may occur");
        } else {
            array[top] = element;
            top++;
        }
    }

    // Removes and returns the upmost element
    public int pop() {
        int temp = 0;
        // underflow handling
        if (isEmpty()) {
            System.out.println("Stack Underflow may occur");
        } else {
            // As top was increased to a blank position while pushing
            top--;
            temp = array[top];
            array[top] = 0;
        }
        return temp;
    }

    // To see upmost element
    public void peek() {
        System.out.println("Element : " + array[top - 1]);
    }

    // Prints stack
    public void show() {
        if (size() == 0) {
            System.out.println("Stack Empty!");
        }
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // Returns size
    public int size() {
        return top;
    }

    // Checks wether stack is empty or not
    public boolean isEmpty() {
        if (top <= 0) {
            return true;
        }
        return false;
    }
}

// Implementation
class test {
    public static void main(String[] args) {
        Stack s = new Stack(3);

        s.push(2);
        s.show();
        s.push(1);
        s.peek();
        s.show();
        s.push(6);
        s.push(4);
        System.out.println(s.size());
        System.out.println(s.isEmpty());
        s.peek();
        s.show();
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }
}
