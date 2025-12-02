class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int MOD = 1000000007;
        for(int[] arr: points) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        long ans = 0;
        long sum = 0;
        for(int ele: map.values()) {
            long edge = ((long) ele * (ele - 1) / 2);
            ans = (ans + edge * sum) % MOD;
            sum = (sum + edge) % MOD;
        }
        return (int) ans;
    }
}