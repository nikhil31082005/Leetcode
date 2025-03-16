class Solution {
    public long repairCars(int[] ranks, int cars) {
        long ans = -1;
        long lo = 1;
        int max = Integer.MIN_VALUE;
        for (int ele : ranks) {
            max = Math.max(max, ele);
        }
        long hi = (long) max * cars * cars;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isPossible(ranks, cars, mid)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] ranks, int cars, long mid) {
        long carsRepaired = 0; 
        for (int ele : ranks) {
            carsRepaired += (long) Math.floor(Math.sqrt(mid / ele));
            if (carsRepaired >= cars) return true; 
        }
        return carsRepaired >= cars;
    }
}
