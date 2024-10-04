public class ExplorerQueue {
    private String[] queue; // Array for holding the explorers
    private int front;      // Points to the front of the queue
    private int rear;       // Points to the rear of the queue
    private int size;       // Current size of the queue
    private int capacity;   // Maximum capacity of the queue

    // Constructor to initialize the queue with a given capacity
    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue a new explorer to the queue
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add explorer: " + explorer);
            return;
        }
        rear = (rear + 1) % capacity; // Move the rear pointer in a circular manner
        queue[rear] = explorer;
        size++;
        System.out.println("Enqueued explorer: " + explorer);
    }

    // Dequeue the front explorer from the queue
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No explorer to dequeue.");
            return null;
        }
        String explorer = queue[front];
        front = (front + 1) % capacity; // Move the front pointer in a circular manner
        size--;
        System.out.println("Dequeued explorer: " + explorer);
        return explorer;
    }

    // Display the next explorer in line (front of the queue)
    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No explorer in line.");
            return null;
        }
        return queue[front];
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print the current queue (for debugging purposes)
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        System.out.print("Current queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ExplorerQueue explorerQueue = new ExplorerQueue(5);

        // Adding explorers to the queue
        explorerQueue.enqueue("Explorer 1");
        explorerQueue.enqueue("Explorer 2");
        explorerQueue.enqueue("Explorer 3");

        // Print the current queue
        explorerQueue.printQueue();

        // Peek at the next explorer
        System.out.println("Next explorer: " + explorerQueue.peek());

        // Dequeue explorers
        explorerQueue.dequeue();
        explorerQueue.printQueue();

        // Dequeue again
        explorerQueue.dequeue();
        explorerQueue.printQueue();

        // Adding more explorers to demonstrate circular behavior
        explorerQueue.enqueue("Explorer 4");
        explorerQueue.enqueue("Explorer 5");
        explorerQueue.enqueue("Explorer 6"); // Should not be added as the queue is full

        explorerQueue.printQueue();
    }
}
