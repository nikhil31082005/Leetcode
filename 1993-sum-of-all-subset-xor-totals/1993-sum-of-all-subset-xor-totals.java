class Solution {
    public int subsetXORSum(int[] nums) {
        int or = nums[0];
        for(int i=1;i<nums.length;i++){
            or |= nums[i];
        }

        return or << (nums.length - 1);
    }
}