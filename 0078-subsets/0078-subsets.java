class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        findSubset(ls, nums, 0, new ArrayList<>());
        return ls;
    }
    public void findSubset(List<List<Integer>> ls, int[] nums, int idx, List<Integer> tempList){
        ls.add(new ArrayList<>(tempList));

        for(int i = idx; i < nums.length; i++){
            tempList.add(nums[i]);
            findSubset(ls, nums, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }

    }
}