class Solution {
    public int subsetXORSum(int[] nums) {
        return xorSum(nums, 0, 0);
    }
    public int xorSum(int[] nums, int idx, int currXor){
        if(idx == nums.length){
            return currXor;
        }

        int take = xorSum(nums, idx + 1, currXor ^ nums[idx]);
        int nottake = xorSum(nums, idx + 1, currXor);

        return take + nottake;
    }
}