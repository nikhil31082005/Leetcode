class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0;
        int count = 1;
        int lastColor = colors[0];
        for(int i=1;i<colors.length + k - 1;i++){
            int idx = i % colors.length;
            if(colors[idx] == lastColor){
                count = 1;
                lastColor = colors[idx];
                continue;
            }
            count++;
            if(count >= k){
                ans++;
            }
            lastColor = colors[idx];
        }
        return ans;
    }
}