class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            boolean ans = canBePartition(i, String.valueOf(i * i), 0, 0);
            if(ans){
                sum += i * i;
            }
        }
        return sum;
    }
    public boolean canBePartition(int n, String sq, int idx, int sum){
        if(idx == sq.length()){
            return n == sum;
        }
        for(int i = idx + 1; i <= sq.length(); i++){
            int a = Integer.parseInt(sq.substring(idx, i));
            if(canBePartition(n, sq, i, sum + a)){
                return true;
            }
        }
        return false;
    }
}