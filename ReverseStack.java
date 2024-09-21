import java.util.Stack;

public class ReverseStack {
    
    // Function to reverse the stack
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Reverse the remaining stack
        reverse(stack);

        // Step 3: Insert the popped element at the bottom
        insertAtBottom(stack, top);
    }

    // Helper function to insert an element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            // Step 1: Pop all elements
            int top = stack.pop();

            // Step 2: Insert the item at the bottom
            insertAtBottom(stack, item);

            // Step 3: Push the popped element back on top
            stack.push(top);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        reverse(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
