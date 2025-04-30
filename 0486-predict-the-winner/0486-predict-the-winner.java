class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for(int ele: nums){
            sum += ele;
        }
        int max = canWin(nums, 0, nums.length-1);
        return max * 2 >= sum;
    }
    public int canWin(int[] nums, int i, int j){
        if(i > j){
            return 0;
        }

        int a = nums[i] + Math.min(canWin(nums, i+2, j), canWin(nums, i+1, j-1));
        int b = nums[j] + Math.min(canWin(nums, i+1, j-1), canWin(nums, i, j-2));

        return Math.max(a, b);
    }
}