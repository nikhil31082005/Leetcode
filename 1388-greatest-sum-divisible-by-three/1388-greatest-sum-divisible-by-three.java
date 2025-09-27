class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int ele: nums) {
            int[] curr = dp.clone();
            for(int i=0;i<3;i++){
                if(dp[i] != Integer.MIN_VALUE) {
                    int sum = dp[i] + ele;
                    int newR = sum % 3;
                    curr[newR] = Math.max(curr[newR], sum);
                }
            }
            dp = curr;
        }
        return dp[0];
    }
}