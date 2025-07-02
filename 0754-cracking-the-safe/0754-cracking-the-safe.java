class Solution {
    HashSet<String> set;
    StringBuilder ans;
    public String crackSafe(int n, int k) {
        if(n == 1 && k == 1) return "0";
        set = new HashSet<>();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n-1;i++){
            sb.append("0");
        }
        String start = sb.toString();

        dfs(start, k);

        ans.append(start);
        return ans.toString();

    }
    public void dfs(String start, int k){
        for(int i=0;i<k;i++){
            String nbr = start + i;
            if(!set.contains(nbr)){
                set.add(nbr);
                dfs(nbr.substring(1), k);
                ans.append(i);
            }
        }
    }
}