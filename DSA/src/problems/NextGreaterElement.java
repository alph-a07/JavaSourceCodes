package problems;

import stacks.DynamicStack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 1, 3, 4, 7};
        nextGreaterElement(array);
    }

    public static void nextGreaterElement(int[] array) {
        DynamicStack stack = new DynamicStack(7);

        for (int j : array) {
            // Firstly stack is empty hence while loop won't be executed and 0th element will be pushed
            // After push, i = 1(next element)
            // Hence if next element is greater than the element in stack -> That's the output
            // Otherwise push it too
            while (!stack.isEmpty() && j > stack.peek()) {
                // The top element will get the output and will be popped out
                int r = stack.pop();
                System.out.println(r + "->" + j);
            }
            stack.push(j);
        }
        while (!stack.isEmpty()) {
            // The elements which got the output were popped out
            // Hence the remaining elements in stack don't have next greater element
            int r = stack.pop();
            System.out.println(r + "->" + "-1");
        }
    }

    // ----- TIME COMPLEXITY ----- //
    // All the elements are pushed and popped out once
    // Push and Pop take constant time
    // Total time = 2 * Number of elements * CONSTANT
    // Hence, time complexity = 2N = O(N)
}
