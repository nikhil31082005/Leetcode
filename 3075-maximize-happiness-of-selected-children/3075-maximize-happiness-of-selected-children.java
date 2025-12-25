class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;

        int count = 0;
        for(int i=happiness.length-1;i>=happiness.length - k;i--){
            ans += (happiness[i] - count >= 0) ? happiness[i] - count : 0;
            count++;
        }
        return ans;
    }
}