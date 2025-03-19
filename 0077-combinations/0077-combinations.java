class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ls = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), ls);
        return ls;
    }
    public void combine(int n, int k, int start, List<Integer> tempList, List<List<Integer>> ls){
        if(tempList.size() == k){
            ls.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=start;i<=n;i++){
            tempList.add(i);
            combine(n,k,i+1, tempList, ls);
            tempList.remove(tempList.size() - 1);
        }
    }
}