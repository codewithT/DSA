class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = right = null;
    }
}

public class BinaryTreeFromArrayDFS {

    // Recursive function to construct BT using DFS
    public static TreeNode constructBT(int[] arr, int i) {
        if (i >= arr.length) return null; // Base case

        // Create a new node
        TreeNode root = new TreeNode(arr[i]);

        // Recursively construct left and right subtrees
        root.left = constructBT(arr, 2 * i + 1);
        root.right = constructBT(arr, 2 * i + 2);

        return root;
    }

    // Inorder traversal to verify tree structure
    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = constructBT(arr, 0);

        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);  // Expected Output: 4 2 5 1 6 3 7
    }
}
