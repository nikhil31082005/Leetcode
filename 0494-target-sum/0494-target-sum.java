class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums, 0, target, 0);
    }
    public int ways(int[] nums, int idx, int target, int sum){
        if(idx >= nums.length){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        String key = idx + " " + sum;

        if(map.containsKey(key)){
            return map.get(key);
        }

        int a = ways(nums, idx + 1, target, sum + nums[idx]);
        int b = ways(nums, idx + 1, target, sum - nums[idx]);

        map.put(key, a+b);

        return a + b;
    }
}