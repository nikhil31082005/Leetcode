class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> ls = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    ls.add(new int[]{i, j});
                }
            }
        }

        for(int[] arr: ls){
            int r = arr[0];
            int c = arr[1];

            for(int i=0;i<matrix[0].length;i++){
                matrix[r][i] = 0;
            }
            for(int i=0;i<matrix.length;i++){
                matrix[i][c] = 0;
            }
        }
        
    }
}