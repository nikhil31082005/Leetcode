class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls = new ArrayList<>();
        findCombination(ls, candidates, target, 0, new ArrayList<>());
        return ls;
    }
    public void findCombination(List<List<Integer>> ls, int[] candidates, int target, int idx, List<Integer> tempList){
        if(target == 0){
            ls.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(target - candidates[i] >= 0){
                tempList.add(candidates[i]);
                findCombination(ls, candidates, target - candidates[i], i + 1, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}