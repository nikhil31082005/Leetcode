class Solution {
    public int triangularSum(int[] nums) {
        int sum = 0;
        int op = 0;
        while(op < nums.length-1){
            for(int i=0;i<nums.length-op-1;i++){
                // System.out.print(nums[i] + " ");
                // System.out.println();
                nums[i] = nums[i] + nums[i+1];
                if(nums[i] >= 10){
                    nums[i] = nums[i] % 10;
                }
            }
            op++;
        }
        return nums[0];
    }
}