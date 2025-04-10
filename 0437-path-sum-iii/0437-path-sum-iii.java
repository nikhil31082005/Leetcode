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
    HashMap<Long, Integer> map = new HashMap<>();
    int c = 0;
    public int pathSum(TreeNode root, int targetSum) {
        countPath(root, targetSum, 0);
        return c;
    }
    public void countPath(TreeNode root, int targetSum, long sum){
        if(root == null){
            return;
        }

        sum += root.val;
        if(sum == targetSum){
            c++;
        }
        c = c + map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        countPath(root.left, targetSum, sum);
        countPath(root.right, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
        if(map.get(sum) == 0){
            map.remove(sum);
        }
    }
}