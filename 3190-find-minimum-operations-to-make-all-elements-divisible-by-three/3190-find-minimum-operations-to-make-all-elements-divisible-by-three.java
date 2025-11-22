class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;

        for(int ele: nums) {
            count += Math.min(ele % 3, 3 - ele % 3);
        }
        return count;
    }
}