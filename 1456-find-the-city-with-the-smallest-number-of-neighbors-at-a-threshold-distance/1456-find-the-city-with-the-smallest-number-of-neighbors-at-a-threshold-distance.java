class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] matrix = new int[n][n];

        for(int[] edge: edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                if(i == j) matrix[i][j] = 0; 
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }

                }
            }
        }

        int ans = -1;
        int ansCount = Integer.MAX_VALUE;

        for(int[] arr: matrix) {
            System.out.println(Arrays.toString(arr));
        }

        for(int i=0;i<n;i++){
            int c = 0;
            for(int j=0;j<n;j++){
                if(i != j && matrix[i][j] <= distanceThreshold) {
                    c++;
                }
            }
            if(c <= ansCount) {
                ans = i;
                ansCount = c;
            }
        }
        return ans;
        
    }
}