class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] delta = new int[nums.length+1];
        for(int[] q: queries){
            int l = q[0];
            int r = q[1];
            delta[l] += 1;
            delta[r+1] -= 1;
        }

        int[] op = new int[delta.length];
        int c = 0;
        for(int i=0;i<delta.length;i++){
            c += delta[i];
            op[i] = c;
        }
        for(int i=0;i<delta.length-1;i++){
            if(op[i] < nums[i]){
                return false;
            }
        }
        return true;
    }
}