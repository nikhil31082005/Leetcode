class Solution {
    int ans = 0;
    public int minIncrements(int n, int[] cost) {
        int maxCost = findMaxCost(n, cost, 0);
        // System.out.print(maxCost);

        return ans;
    }
    public int findMaxCost(int n, int[] cost, int idx){
        if(idx >= n){
            return 0;
        }

        int a = findMaxCost(n, cost, 2 * (idx + 1) - 1);
        int b = findMaxCost(n, cost, 2 * (idx + 1));

        ans += Math.abs(a - b);

        return cost[idx] + Math.max(a, b);
    }
}