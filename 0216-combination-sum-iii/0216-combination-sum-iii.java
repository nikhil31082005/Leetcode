class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ls = new ArrayList<>();
        findCombination(ls, k, n, new ArrayList<>(), 1);
        return ls;
    }
    public void findCombination(List<List<Integer>> ls, int k, int n, List<Integer> tempList, int idx){
        if(n == 0 && tempList.size() == k){
            ls.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = idx; i <= 9; i++){
            if(n - i >= 0){
                tempList.add(i);
                findCombination(ls, k, n - i, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}