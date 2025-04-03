class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            prefix[i] = Math.max(prefix[i-1], nums[i-1]);
        }

        suffix[nums.length - 1] = Integer.MIN_VALUE;
        for(int i=nums.length-2;i>=0;i--){
            suffix[i] = Math.max(suffix[i+1], nums[i+1]);
        }

        long ans = 0;

        for(int i=1;i<nums.length-1;i++){
            ans = Math.max(ans, (long) (prefix[i] - nums[i]) * suffix[i]);
        }
        return ans;
    }
}