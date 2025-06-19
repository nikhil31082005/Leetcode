class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int c = 1;
        int a = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] - a > k){
                c++;
                a = nums[i];
            }
        }
        return c;
    }
}