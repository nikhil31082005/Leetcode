class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, 0, 0, "", n);
        return ans;
    }
    public void generate(List<String> result, int open, int close, String ans, int n){
        if(open == n && close == n){
            result.add(ans);
            return;
        }

        if(open > n) return;

        if(close > open) return;

        generate(result, open + 1, close, ans + '(', n);
        generate(result, open, close + 1, ans + ')', n);
    }
}