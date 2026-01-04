class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;

        int ans = nums.length + 1;
        int sum = 0;
        for(int end = 0; end < nums.length; end++) {
            if(!map.containsKey(nums[end])) {
                sum += nums[end];
            }
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while(sum >= k) {
                ans = Math.min(ans, end - start + 1);
                int count = map.get(nums[start]);
                if (count == 1) {
                    sum -= nums[start];
                    map.remove(nums[start]);   // ✅ FIX
                } else {
                    map.put(nums[start], count - 1);
                }
                start++;
            }
        }
        return ans == nums.length + 1 ? -1: ans;
    }
}