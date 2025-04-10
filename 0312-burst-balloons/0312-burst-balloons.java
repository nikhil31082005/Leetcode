class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[arr.length - 1] = 1;
        for(int i=1;i<arr.length - 1;i++){
            arr[i] = nums[i-1];
        }
        int[][] dp = new int[arr.length][arr.length];
        for(int[] ele: dp){
            Arrays.fill(ele, -1);
        }
        return burst(arr, 0, arr.length-1, dp);
    }
    public int burst(int[] arr, int start, int end, int[][] dp){
        if(start + 1 == end){
            return 0;
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        int max = Integer.MIN_VALUE;
        for(int i=start + 1; i < end ; i++){
            int left = burst(arr, start, i, dp);
            int right = burst(arr, i, end, dp);
            int self = arr[start] * arr[i] * arr[end];
            max = Math.max(max, left + right + self);
        }
        dp[start][end] = max;
        return max;
    }
}