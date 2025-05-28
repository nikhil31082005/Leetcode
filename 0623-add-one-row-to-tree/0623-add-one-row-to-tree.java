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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, val, depth, 1);
        return root;
    }
    public void addRow(TreeNode root, int val, int depth, int curr){
        if(root == null){
            return;
        }
        if(depth == curr + 1){
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);

            newLeft.left = root.left;
            newRight.right = root.right;

            root.left = newLeft;
            root.right = newRight;
        }
        else{
            addRow(root.left, val, depth, curr + 1);
            addRow(root.right, val, depth, curr + 1);
        }
    }
}