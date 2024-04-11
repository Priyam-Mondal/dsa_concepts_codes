package bst;

class Node {
    int data;
    Node left;
    Node right;
    
    // Constructor to initialize a node with data
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// BuildTree class contains methods to build, manipulate, and traverse the binary search tree
class BuildTree {
    Node root;

    // Method to insert a new node in the binary search tree
    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Method to delete a node from the binary search tree
    Node deleteFromBst(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (root.data == key) {
            // 0 child
            if (root.left == null && root.right == null) {
                return null;
            }

            // 1 child

            // left child
            if (root.left == null && root.right != null) {
                Node temp = root.right;
                root.right = null;
                return temp;
            }
            // right child
            if (root.left != null && root.right == null) {
                Node temp = root.left;
                root.left = null;
                return temp;
            }

            // 2 child
            if (root.left != null && root.right != null) {
                int mini = findMin(root.right);
                root.data = mini;
                root.right = deleteFromBst(root.right, mini);
                return root;
            }
        } else if (root.data > key) {
            root.left = deleteFromBst(root.left, key);
            return root;
        } else {
            root.right = deleteFromBst(root.right, key);
            return root;
        }
        return root;
    }

    // Method to perform level order traversal of the binary search tree
    void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root); // Add the root node to the queue

        while (!q.isEmpty()) { // Continue the loop until the queue is empty
            Node temp = q.poll(); // Remove and retrieve the front node from the queue
            System.out.print(temp.data + "->"); // Print the data of the current node

            // Add the left child to the queue if it exists
            if (temp.left != null) {
                q.add(temp.left);
            }
            // Add the right child to the queue if it exists
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    // Method to search for a key in the binary search tree
    Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == key)
            return root;

        // Key is greater than root's key
        if (root.data < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    // Method to find the minimum value in the binary search tree
    int findMin(Node root) {
        if (root == null) {
            return root.data;
        }
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    // Method to find the maximum value in the binary search tree
    int findMax(Node root) {
        if (root == null) {
            return root.data;
        }
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.data;
    }
}

public class BSTImplement {

    public static void main(String[] args) {
        BuildTree tr = new BuildTree();

        // Inserting elements into the binary search tree
        tr.root = tr.insert(tr.root, 50);
        tr.insert(tr.root, 20);
        tr.insert(tr.root, 70);
        tr.insert(tr.root, 10);
        tr.insert(tr.root, 30);
        tr.insert(tr.root, 90);
        tr.insert(tr.root, 110);

        // Performing level order traversal of the binary search tree
        tr.levelOrder(tr.root);

        System.out.println("\n");
        // Key to be found
        int key = 6;

        // Searching for a key in the binary search tree
        if (tr.search(tr.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");

        key = 60;

        // Searching for a key in the binary search tree
        if (tr.search(tr.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");

        System.out.println("\n Min : " + tr.findMin(tr.root) + " Max : " + tr.findMax(tr.root));

        System.out.println("After deleting : ");
        Node newRoot = tr.deleteFromBst(tr.root, 50);
        tr.levelOrder(newRoot);
    }
}