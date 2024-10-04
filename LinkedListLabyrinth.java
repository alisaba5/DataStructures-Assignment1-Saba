public class LabyrinthPath {
    private Node head;
    private Node tail;

    // Node class representing each location in the labyrinth
    private static class Node {
        String location;
        Node next;

        Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    // Constructor
    public LabyrinthPath() {
        head = null;
        tail = null;
    }

    // Add a new location to the path
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Added location: " + location);
    }

    // Remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("No locations to remove.");
            return;
        }
        if (head == tail) {
            System.out.println("Removed location: " + head.location);
            head = null;
            tail = null;
            return;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        System.out.println("Removed location: " + tail.location);
        current.next = null;
        tail = current;
    }

    // Check if the path contains a loop (trap)
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow by one
            fast = fast.next.next;   // Move fast by two
            if (slow == fast) {
                System.out.println("Loop detected in the path!");
                return true;
            }
        }
        System.out.println("No loop detected in the path.");
        return false;
    }

    // Print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("The path is empty.");
            return;
        }
        Node current = head;
        System.out.print("Path: ");
        while (current != null) {
            System.out.print(current.location + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath();

        // Adding locations
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Room A");
        path.addLocation("Room B");

        // Printing the path
        path.printPath();

        // Removing the last location
        path.removeLastLocation();
        path.printPath();

        // Checking for loops
        path.hasLoop();

        // Create a loop for testing
        path.tail.next = path.head; // Creating a loop for testing
        path.hasLoop();
    }
}
