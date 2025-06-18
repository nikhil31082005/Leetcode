class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][3];

        Arrays.sort(nums);
        int l = 0;
        for(int i=0;i<nums.length;i+=3){
            if(nums[i+2] - nums[i] > k){
                return new int[][]{};
            }
            int idx = i;
            for(int j=0;j<3;j++){
                result[l][j] = nums[idx++];
            }
            l++;
        }
        return result;
    }
}