class Solution {
    public long coloredCells(int n) {
        long ans = 1 + (long) 4 * n * (n - 1) / 2;
        return ans;
    }
}