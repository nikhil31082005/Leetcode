class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0;

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                decodedLength *= (ch - '0');
            }
            else{
                decodedLength++;
            }
        }

        for(int i=s.length() - 1; i>=0;i--){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                decodedLength /= (ch - '0');
                k %= decodedLength;
            }
            else{
                if(k == 0 || decodedLength == k){
                    return String.valueOf(ch);
                }
                decodedLength--;
            }
        }
        return "";
    }
}