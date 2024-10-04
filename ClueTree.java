public class ClueTree {
    // Binary Tree Node
    private static class Node {
        String clue;
        Node left;
        Node right;

        Node(String clue) {
            this.clue = clue;
            left = right = null;
        }
    }

    private Node root; // The root of the binary tree

    // Constructor
    public ClueTree() {
        root = null;
    }

    // Insert a new clue into the binary tree
    public void insert(String clue) {
        root = insertRecursive(root, clue);
    }

    // Helper method to insert a new clue recursively
    private Node insertRecursive(Node root, String clue) {
        if (root == null) {
            return new Node(clue); // Create a new node if it's a leaf
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRecursive(root.left, clue); // Insert into left subtree
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRecursive(root.right, clue); // Insert into right subtree
        }
        return root;
    }

    // Perform in-order traversal (Left, Root, Right)
    public void inOrderTraversal() {
        System.out.print("In-order traversal: ");
        inOrderRecursive(root);
        System.out.println();
    }

    // Helper method for in-order traversal
    private void inOrderRecursive(Node root) {
        if (root != null) {
            inOrderRecursive(root.left);
            System.out.print(root.clue + " ");
            inOrderRecursive(root.right);
        }
    }

    // Perform pre-order traversal (Root, Left, Right)
    public void preOrderTraversal() {
        System.out.print("Pre-order traversal: ");
        preOrderRecursive(root);
        System.out.println();
    }

    // Helper method for pre-order traversal
    private void preOrderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    // Perform post-order traversal (Left, Right, Root)
    public void postOrderTraversal() {
        System.out.print("Post-order traversal: ");
        postOrderRecursive(root);
        System.out.println();
    }

    // Helper method for post-order traversal
    private void postOrderRecursive(Node root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a specific clue in the tree
    public boolean findClue(String clue) {
        return findClueRecursive(root, clue);
    }

    // Helper method to find a specific clue recursively
    private boolean findClueRecursive(Node root, String clue) {
        if (root == null) {
            return false; // Clue not found
        }
        if (clue.equals(root.clue)) {
            return true; // Clue found
        }
        if (clue.compareTo(root.clue) < 0) {
            return findClueRecursive(root.left, clue); // Search in left subtree
        } else {
            return findClueRecursive(root.right, clue); // Search in right subtree
        }
    }

    // Count the total number of clues in the tree
    public int countClues() {
        return countCluesRecursive(root);
    }

    // Helper method to count the total number of clues recursively
    private int countCluesRecursive(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countCluesRecursive(root.left) + countCluesRecursive(root.right); // Count root + left subtree + right subtree
    }

    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree();

        // Inserting clues into the binary tree
        clueTree.insert("Clue A");
        clueTree.insert("Clue B");
        clueTree.insert("Clue C");
        clueTree.insert("Clue D");
        clueTree.insert("Clue E");

        // Perform different traversals
        clueTree.inOrderTraversal();   // Should print: Clue A Clue B Clue C Clue D Clue E
        clueTree.preOrderTraversal();  // Should print: Clue A Clue B Clue C Clue D Clue E
        clueTree.postOrderTraversal(); // Should print: Clue E Clue D Clue C Clue B Clue A

        // Finding a specific clue
        System.out.println("Find Clue B: " + clueTree.findClue("Clue B")); // Should print: true
        System.out.println("Find Clue F: " + clueTree.findClue("Clue F")); // Should print: false

        // Counting the total number of clues
        System.out.println("Total number of clues: " + clueTree.countClues()); // Should print: 5
    }
}
