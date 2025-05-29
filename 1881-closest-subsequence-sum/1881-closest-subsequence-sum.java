class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();

        int[] left = Arrays.copyOfRange(nums, 0, n / 2);
        int[] right = Arrays.copyOfRange(nums, n / 2, n);

        generateSubsetSums(left, 0, 0, leftSums);
        generateSubsetSums(right, 0, 0, rightSums);

        Collections.sort(rightSums);

        int ans = Integer.MAX_VALUE;
        for(int ele: leftSums){
            int target = goal - ele;
            int closest = binarySearch(rightSums, target);
            ans = Math.min(ans, Math.abs(ele + closest - goal));
        }
        return ans;
    }
    public int binarySearch(List<Integer> leftSum, int target){
        int lo = 0;
        int hi = leftSum.size() - 1;
        int closest = leftSum.get(0);
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int val = leftSum.get(mid);

            if (Math.abs(val - target) < Math.abs(closest - target)) {
                closest = val;
            }

            if (val < target) {
                lo = mid + 1;
            } else if (val > target) {
                hi = mid - 1;
            } else {
                return val;
            }
        }
        return closest;
    }
    public void generateSubsetSums(int[] nums, int sum, int idx, List<Integer> ls){
        if(idx >= nums.length){
            ls.add(sum);
            return;
        }

        generateSubsetSums(nums, sum + nums[idx], idx + 1, ls);
        generateSubsetSums(nums, sum, idx + 1, ls);
    }
}