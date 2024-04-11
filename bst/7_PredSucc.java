package bst;

public class 7_PredSucc {
    // Static nodes to store predecessor and successor
    static Node pre = null;
    static Node suc = null;

    // Function to find predecessor and successor of given key
    public static void findPreSuc(Node root, int key) {
        findPre(root, key);
        findSuc(root, key);
    }

    // Function to find predecessor
    static void findPre(Node root, int key) {
        if (root == null)
            return;

        if (root.data == key) {
            // If the key has a left subtree, predecessor is the rightmost node of that subtree
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                pre = temp;
            }
            return;
        }

        // If key is smaller than root's data, search in the left subtree
        if (root.data > key) {
            findPre(root.left, key);
        } else {
            // If key is greater than root's data, update predecessor and search in the right subtree
            pre = root;
            findPre(root.right, key);
        }
    }

    // Function to find successor
    static void findSuc(Node root, int key) {
        if (root == null)
            return;

        if (root.data == key) {
            // If the key has a right subtree, successor is the leftmost node of that subtree
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                suc = temp;
            }
            return;
        }

        // If key is smaller than root's data, update successor and search in the left subtree
        if (root.data > key) {
            suc = root;
            findSuc(root.left, key);
        } else {
            // If key is greater than root's data, search in the right subtree
            findSuc(root.right, key);
        }
    }
}
