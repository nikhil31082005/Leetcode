class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        int[] groupSize = new int[n];
        int[] prevEle = new int[n];
        int maxIndex = 0;
        for(int i=0;i<n;i++) {
            groupSize[i] = 1;
            prevEle[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (groupSize[i] < groupSize[j] + 1) {
                        groupSize[i] = groupSize[j] + 1;
                        prevEle[i] = j;
                    }
                }
            }
            if (groupSize[i] > groupSize[maxIndex]) {
                maxIndex = i;
            }
        }
        while(maxIndex!=-1){
            ls.add(0,nums[maxIndex]);
            maxIndex = prevEle[maxIndex];
        }
        return ls;
    }
}