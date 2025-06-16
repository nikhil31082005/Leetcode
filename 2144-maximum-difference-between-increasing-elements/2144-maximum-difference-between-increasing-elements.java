class Solution {
    public int maximumDifference(int[] nums) {
        int res = 0;
        int  min = nums[0];
        for(int i=1;i<nums.length;i++){
            res = Math.max(res,nums[i]-min);
            min = Math.min(min,nums[i]);
        } 
        if(res==0) return -1;
        return res;
    }
}