class Solution {
    static final long MOD = 1_000_000_007L;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        List<Long> base = new ArrayList<>();
        for (int cnt : map.values()) {
            if (cnt >= 2) {
                long c = ((long) cnt * (cnt - 1)) / 2;
                base.add(c % MOD);
            }
        }

        long total = 0;
        long prefix = 0;

        for (long c : base) {
            total = (total + (prefix * c) % MOD) % MOD;
            prefix = (prefix + c) % MOD;
        }

        return (int) total;
    }
}
