class Solution {
    public int centeredSubarrays(int[] nums) {
        int len = nums.length, ans = 0;
        for(int i = 0; i < len; ++i) {
            Set<Integer> f = new HashSet<>();
            for(int j = i, s = 0; j < len; ++j) {
                f.add(nums[j]);
                s += nums[j];
                if(f.contains(s)) ++ans;
            }
        }
        return ans;
    }
}