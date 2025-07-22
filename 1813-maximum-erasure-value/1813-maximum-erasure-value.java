class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int end = 0; end < nums.length; end++){
            sum += nums[end];
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while(map.get(nums[end]) >= 2){
                map.put(nums[start], map.get(nums[start]) - 1);
                sum -= nums[start];
                if(map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                }
                start++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}