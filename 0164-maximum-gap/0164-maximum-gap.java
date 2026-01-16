class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        // ✅ FIX 1: correct gap
        int gap = (int) Math.ceil((double)(max - min) / (n - 1));

        // ✅ FIX 2: correct bucket count
        int bucketCount = (max - min) / gap + 1;

        int[] minBucket = new int[bucketCount];
        int[] maxBucket = new int[bucketCount];

        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            int idx = (num - min) / gap;
            minBucket[idx] = Math.min(minBucket[idx], num);
            maxBucket[idx] = Math.max(maxBucket[idx], num);
        }

        int maxGap = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) continue;

            maxGap = Math.max(maxGap, minBucket[i] - prevMax);
            prevMax = maxBucket[i];
        }

        return maxGap;
    }
}
