class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int maxLength = 0;
        int count = 0;

        for(int end = 0; end < nums.length; end++) {
            if(nums[end] == 0) {
                count++;
            }

            while(count > 1) {
                if(nums[start] == 0) {
                    count--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }
}