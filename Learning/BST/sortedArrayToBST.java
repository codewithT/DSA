
// Given an integer array nums where the elements are sorted
//  in ascending order, convert it to a height-balanced binary search tree.

 

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;  // Middle element
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBST(nums, left, mid - 1);  // Construct left subtree
        root.right = constructBST(nums, mid + 1, right); // Construct right subtree

        return root;
    }
}
