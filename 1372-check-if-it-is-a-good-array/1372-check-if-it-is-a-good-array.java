class Solution {
    public boolean isGoodArray(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            if(result == 1){
                return true;
            }
            result = gcd(nums[i], result);
        }
        if(result == 1){
            return true;
        }
        return false;
    }
    public int gcd(int a, int b){
        while(a % b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return b;
    }
}