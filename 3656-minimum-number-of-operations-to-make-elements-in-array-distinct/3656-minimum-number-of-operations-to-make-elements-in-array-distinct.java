class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > 1){
                return (i + 1) % 3 == 0 ? (i + 1) / 3 : 1 + (i + 1) / 3 ;
            }
        }
        return 0;
    }
}