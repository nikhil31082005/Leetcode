class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ls = new ArrayList<>();
        counting(n, 0, ls);
        return ls;
    }
    public void counting(int n, int ans, List<Integer> ls){
        if(ans > n){
            return;
        }

        if(ans != 0){
            ls.add(ans);
        }

        int i = 0;
        if(ans == 0){
            i = 1;
        }


        for(; i<= 9; i++){
            counting(n, ans * 10 + i, ls);
        }
    }
}