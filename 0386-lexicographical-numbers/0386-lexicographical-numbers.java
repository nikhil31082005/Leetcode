class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ls = new ArrayList<>();
        print(n, ls, 0);
        return ls;
    }
    public void print(int n, List<Integer> ls, int num){
        if(num > n){
            return;
        }
        if(num != 0){
            ls.add(num);
        }
        if(num == 0){
            for(int i=1;i<=9;i++){
                print(n, ls, num * 10 + i);
            }
        }
        else{
            for(int i=0;i<=9;i++){
                print(n, ls, num * 10 + i);
            }
        }
    }
}