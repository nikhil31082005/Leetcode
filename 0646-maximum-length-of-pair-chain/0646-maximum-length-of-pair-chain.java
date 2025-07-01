class Solution {
    public int findLongestChain(int[][] activities) {
        Arrays.sort(activities, (a, b) -> {
            return a[1] - b[1];
        });

        int count = 1;
        int lastEnd = activities[0][1];
        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] > lastEnd) {
                count++;
                lastEnd = activities[i][1];
            }
        }

        return count;
    }
}