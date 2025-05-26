class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;

        for(int i=1;i<=6;i++){
            int swap = findSwap(tops, bottoms, i);
            if(swap != -1){
                ans = Math.min(ans, swap);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int findSwap(int[] tops, int[] bottoms, int n){
        int top = 0, bottom = 0;
        for(int i=0;i<tops.length;i++){
            if(tops[i] != n && bottoms[i] != n){
                return -1;
            }
            if(tops[i] != n){
                top++;
            }
            if(bottoms[i] != n){
                bottom++;
            }
        }
        return Math.min(top, bottom);
    }
}