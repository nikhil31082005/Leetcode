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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        return countPath(root, targetSum, 0l) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    public int countPath(TreeNode root, int targetSum, long sum){
        if(root == null){
            return 0;
        }
        int c = 0;
        if(targetSum == sum + root.val){
            c++;
        }
        
        int left = countPath(root.left, targetSum, sum + root.val);
        int right = countPath(root.right, targetSum, sum + root.val);
        return c + left + right;
    }
}