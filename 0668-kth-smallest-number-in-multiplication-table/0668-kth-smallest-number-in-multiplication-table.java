class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = n * m;
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = countAllSmall(m, n, mid);
            if(count >= k) {
                ans = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    public int countAllSmall(int m, int n, int mid) {
        int row = m - 1;
        int col = 0;
        int count = 0;
        while(row >= 0 && col < n) {
            if((row + 1) * (col + 1) <= mid) {
                count += (row + 1);
                col++;
            }
            else {
                row--;
            }
        }
        return count;
    }
}