class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ls = new ArrayList<>();
        allPartition(ls, s, 0, new ArrayList<>());
        return ls;
    }
    public void allPartition(List<List<String>> ls, String s, int idx, List<String> tempList){
        if(idx >= s.length()){
            ls.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = idx + 1; i <= s.length(); i++){
            if(isPalindrome(s, idx, i-1)){
                tempList.add(s.substring(idx, i));
                allPartition(ls, s, i, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}