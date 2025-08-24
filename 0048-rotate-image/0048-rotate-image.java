class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;

        // transpose
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // reverse every row
        for(int i=0;i<n;i++){
            int s = 0;
            int e = arr[i].length-1;
            while(s<=e){
                int temp = arr[i][s];
                arr[i][s] = arr[i][e];
                arr[i][e] = temp;
                s++;
                e--;
            }
        }
    }
}