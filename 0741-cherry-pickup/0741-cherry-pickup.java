class Solution {
    int N;
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        N = grid.length;
        dp = new int[N][N][N];
        for(int[][] arr: dp) {
            for(int[] brr: arr) {
                Arrays.fill(brr, -1);
            }
        }
        return Math.max(0, maxPick(grid, 0, 0, 0));
    }
    public int maxPick(int[][] grid, int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        
        // Bounds check or Obstacle check (-1)
        if (r1 == N || c1 == N || r2 == N || c2 == N || 
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE/2; 
        }

        if(dp[r1][c1][c2] != -1) {
            return dp[r1][c1][c2];
        }

        // Reached destination
        if (r1 == N - 1 && c1 == N - 1) return grid[r1][c1];
        int cost = 0;
        if(r1 == r2 && c1 == c2) {
            cost += grid[r1][c1];
        }
        else {
            cost += grid[r1][c1] + grid[r2][c2];
        }

        int max = Integer.MIN_VALUE;
        max = Math.max(max, maxPick(grid, r1 + 1, c1, c2));
        max = Math.max(max, maxPick(grid, r1 + 1, c1, c2 + 1));
        max = Math.max(max, maxPick(grid, r1, c1 + 1, c2));
        max = Math.max(max, maxPick(grid, r1, c1 + 1, c2 + 1));

        return dp[r1][c1][c2] = max + cost;
    }
}