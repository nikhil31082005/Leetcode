class Solution {
    String[] digit = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        allCombination(digits, 0, "");
        return result;
    }
    public void allCombination(String digits, int idx, String ans){
        if(idx == digits.length()){
            result.add(ans);
            return;
        }
        int num = digits.charAt(idx) - '0';
        String s = digit[num];
        for(int i=0;i<s.length();i++){
            allCombination(digits, idx + 1, ans + s.charAt(i));
        }
    }
}