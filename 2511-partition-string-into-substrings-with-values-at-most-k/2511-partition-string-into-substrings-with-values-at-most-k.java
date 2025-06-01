class Solution {
    public int minimumPartition(String s, int k) {
        int count = 1;
        long curr = 0;
        for(int i=0;i<s.length();i++){
            int digit = s.charAt(i) - '0';
            if(digit > k){
                return -1;
            }
            curr = curr * 10 + digit;
            if(curr > k){
                curr = digit;
                count++;
            }
        }
        return count;
    }
}