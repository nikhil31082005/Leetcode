class Solution {
    public int minimumArea(int[][] grid) {
        int l1 = Integer.MAX_VALUE;
        int l2 = Integer.MIN_VALUE;
        int w1 = Integer.MAX_VALUE;
        int w2 = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    l1 = Math.min(i,l1);
                    l2 = Math.max(i,l2);
                    w1 = Math.min(j,w1);
                    w2 = Math.max(j,w2);
                }
            }
        }
        if (l1 == Integer.MAX_VALUE) {
            return 0;
        }
        return (l2 - l1 + 1) * (w2 - w1 + 1);
    }
}