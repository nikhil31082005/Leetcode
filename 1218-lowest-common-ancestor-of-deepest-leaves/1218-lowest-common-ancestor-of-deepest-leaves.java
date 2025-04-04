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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = findDepth(root);
        return lca(root, 0, maxDepth);
    }
    public TreeNode lca(TreeNode root, int depth, int  maxDepth){
        if(root == null){
            return null;
        }
        if(depth == maxDepth - 1){
            return root;
        }
        TreeNode left = lca(root.left, depth + 1, maxDepth);
        TreeNode right = lca(root.right, depth + 1, maxDepth);

        if(left != null && right != null){
            return root;
        }

        if(left == null){
            return right;
        }
        return left;
    }
    public int findDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }
}