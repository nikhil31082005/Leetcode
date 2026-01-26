class Solution {
    int[][] jumps = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    int MOD = 1000000007;
    HashMap<String, Integer> map;
    public int knightDialer(int n) {
        map = new HashMap<>();
        int ans = 0;
        for(int i=0;i<=9;i++){
            ans = (ans + dp(n-1, i)) % MOD;
        }
        return ans;
    }
    public int dp(int n, int dig){
        if(n == 0){
            return 1;
        }
        String key = n + " " + dig;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int ans = 0;
        for(int ele: jumps[dig]){
            ans = (ans + dp(n-1, ele)) % MOD;
        }
        map.put(key, ans);
        return ans;
    }
}