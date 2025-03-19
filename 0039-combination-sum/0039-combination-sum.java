class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        combine(candidates, target, 0, new ArrayList<>(), ls);
        return ls;
    }
    public void combine(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> ls){
        if(target == 0){
            ls.add(new ArrayList<>(tempList));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i=start;i<candidates.length;i++){
            tempList.add(candidates[i]);
            combine(candidates, target - candidates[i],i, tempList, ls);
            tempList.remove(tempList.size() - 1);
        }
    }
}