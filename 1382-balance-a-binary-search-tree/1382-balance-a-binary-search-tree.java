/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<TreeNode> sortedNodes = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // Step 1: In-order traversal to get a sorted list of nodes
        inOrder(root);
        
        // Step 2: Build a balanced BST from the sorted list
        return buildBalancedTree(0, sortedNodes.size() - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        sortedNodes.add(root);
        inOrder(root.right);
    }

    private TreeNode buildBalancedTree(int start, int end) {
        if (start > end) return null;

        // Pick the middle element as the root to keep it balanced
        int mid = start + (end - start) / 2;
        TreeNode node = sortedNodes.get(mid);

        // Recursively build the left and right subtrees
        node.left = buildBalancedTree(start, mid - 1);
        node.right = buildBalancedTree(mid + 1, end);

        return node;
    }
}