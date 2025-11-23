class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<String, Integer> map = new HashMap<>();

        int xor = 0;
        int count = 0;
        map.put("0#0", -1);
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            xor ^= nums[i];
            if(nums[i] % 2 == 0) {
                count++;
            }
            else {
                count--;
            }

            String key = xor + "#" + count;

            if(map.containsKey(key)) {
                ans = Math.max(ans, i - map.get(key));
            }
            else {
                map.put(key, i);
            }
        }
        return ans;
    }
}