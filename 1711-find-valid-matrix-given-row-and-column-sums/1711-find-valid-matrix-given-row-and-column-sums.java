class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = Math.min(rowSum[i],colSum[j]);
                rowSum[i] = rowSum[i] - val;
                colSum[j] = colSum[j] - val;
                arr[i][j] = val;
            }
        }
        return arr;
    }
}