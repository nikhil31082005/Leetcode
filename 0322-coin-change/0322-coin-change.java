class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);

        // Calling helper function
        return helper(coins, amount, dp);
    }

    // Helper recursive function
    private int helper(int[] coins, int rem, int[] dp) {
        // If remaining amount is zero
        if (rem == 0) return 0;

        // If remaining amount is negative
        if (rem < 0) return -1;

        // If already computed
        if (dp[rem] != -2) return dp[rem];

        // Initialize minimum with large value
        int mini = Integer.MAX_VALUE;

        // Try every coin
        for (int coin : coins) {
            // Recursive call
            int res = helper(coins, rem - coin, dp);

            // If result is valid
            if (res >= 0 && res < mini)
                mini = 1 + res;
        }

        // Store result in dp
        dp[rem] = (mini == Integer.MAX_VALUE) ? -1 : mini;
        return dp[rem];
    }
}