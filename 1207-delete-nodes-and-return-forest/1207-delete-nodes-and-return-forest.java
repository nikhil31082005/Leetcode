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
    List<TreeNode> ls = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: to_delete){
            set.add(ele);
        }

        root = makeForest(root, set);
        if(root != null){
            ls.add(root);
        }
        return ls;
    }
    public TreeNode makeForest(TreeNode root, HashSet<Integer> set){
        if(root == null){
            return null;
        }

        root.left = makeForest(root.left, set);
        root.right = makeForest(root.right, set);

        if(set.contains(root.val)){
            if(root.left != null) ls.add(root.left);
            if(root.right != null) ls.add(root.right);

            return null;
        }
        return root;
    }
}