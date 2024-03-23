public class Solution {

    // Method to count the number of nodes in the binary tree
    static int countNodes(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        // Counting nodes recursively in the left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Method to check if the binary tree is a complete binary tree
    static boolean isCBT(BinaryTreeNode root, int index, int nodeCnt) {
        if (root == null)
            return true;

        if (index >= nodeCnt)
            return false;
        else {
            boolean left = isCBT(root.left, 2 * index + 1, nodeCnt);
            boolean right = isCBT(root.right, 2 * index + 2, nodeCnt);

            return left && right;
        }
    }

    // Method to check if the binary tree is a max heap
    static boolean isMaxHeap(BinaryTreeNode root) {
        if (root.left == null && root.right == null)
            return true;

        // One child
        if (root.left != null && root.right == null) {
            return root.data >= root.left.data;
        }

        // Two children
        return root.data >= root.left.data && root.data >= root.right.data
                && isMaxHeap(root.left)
                && isMaxHeap(root.right);
    }

    // Method to check if the binary tree is a binary heap tree (CBT and Max Heap)
    public static String isBinaryHeapTree(BinaryTreeNode root) {

        int index = 0;
        int nodeCnt = countNodes(root);

        // Checking if the binary tree is both a complete binary tree and a max heap
        if (isCBT(root, index, nodeCnt) && isMaxHeap(root)) {
            return "True";
        }
        return "False";
    }
}
