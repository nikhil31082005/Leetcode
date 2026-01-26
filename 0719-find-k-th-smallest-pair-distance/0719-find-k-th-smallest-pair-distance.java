class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        int ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = countPair(nums, mid);

            if(count < k) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    public int countPair(int[] nums, int limit) {
        int count = 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && nums[j] - nums[i] <= limit) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }
}