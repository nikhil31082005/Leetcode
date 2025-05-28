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
    int maxDistance = 0;
    public int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return maxDistance;
    }
    public int traverse(TreeNode root, int start){
        int depth = 0;
        if(root == null){
            return depth;
        }

        int left = traverse(root.left, start);
        int right = traverse(root.right, start);

        if(root.val == start){
            maxDistance = Math.max(left, right);
            depth = -1;
        }
        else if(left >= 0 && right >= 0){
            depth = Math.max(left, right) + 1;
        }
        else{
            int distance = Math.abs(left) + Math.abs(right);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(left, right) - 1;
        }
        return depth;
    }
}