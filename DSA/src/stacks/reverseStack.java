package stacks;

import stacks.Stack;

public class reverseStack extends Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.show();
        Stack helper = new Stack(5);
        reverseStack(stack, helper, 0);
        stack.show();
    }

    // This function will reverse the original stack
    public static void reverseStack(Stack stack, Stack helper, int index) {
        // Base Case -- Return when stack is empty after all elements are popped
        if (stack.isEmpty()) {
            return;
        }

        // Pop upmost element from stack and store it in item
        int item = stack.pop();
        // Recursive call - Store all elements until we hit base case
        reverseStack(stack, helper, index + 1);
        // ------ Returned from base case ------
        // item == last element of stack
        // That will be pushed in helper stack
        // Same process until index again becomes 0
        // Helper == Stack
        helper.push(item);

        // Helper filled just like stack
        if (index == 0) {
            // Elements from helper will be popped and pushed in stack according to LIFO principle
            while (!helper.isEmpty()) {
                stack.push(helper.pop());
            }
            // Stack is reversed
        }
    }
}
