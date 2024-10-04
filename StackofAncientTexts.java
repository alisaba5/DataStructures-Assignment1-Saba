import java.util.Arrays;

public class ScrollStack {
    private String[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public ScrollStack(int capacity) {
        this.capacity = capacity;
        stack = new String[capacity];
        top = -1; // Indicates that the stack is empty
    }

    // Push a new scroll onto the stack
    public void push(String scrollTitle) {
        if (top >= capacity - 1) {
            System.out.println("Stack is full! Cannot add scroll: " + scrollTitle);
            return;
        }
        stack[++top] = scrollTitle;
        System.out.println("Pushed scroll: " + scrollTitle);
    }

    // Pop the top scroll off the stack
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return null;
        }
        String removedScroll = stack[top--];
        System.out.println("Popped scroll: " + removedScroll);
        return removedScroll;
    }

    // Peek at the top scroll without removing it
    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return null;
        }
        return stack[top];
    }

    // Check if a specific scroll title exists in the stack
    public boolean contains(String scrollTitle) {
        for (int i = 0; i <= top; i++) {
            if (stack[i].equals(scrollTitle)) {
                System.out.println("Scroll found: " + scrollTitle);
                return true;
            }
        }
        System.out.println("Scroll not found: " + scrollTitle);
        return false;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Print the entire stack (for debugging purposes)
    public void printStack() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ScrollStack scrollStack = new ScrollStack(5);

        // Adding scrolls to the stack
        scrollStack.push("Scroll of Knowledge");
        scrollStack.push("Scroll of Wisdom");
        scrollStack.push("Scroll of Time");

        // Print the current stack
        scrollStack.printStack();

        // Peek at the top scroll
        System.out.println("Peek: " + scrollStack.peek());

        // Check if a specific scroll exists
        scrollStack.contains("Scroll of Wisdom");
        scrollStack.contains("Scroll of Power");

        // Pop the top scroll
        scrollStack.pop();
        scrollStack.printStack();

        // Pop again
        scrollStack.pop();
        scrollStack.pop();
        scrollStack.pop(); // Attempt to pop from an empty stack
    }
}
