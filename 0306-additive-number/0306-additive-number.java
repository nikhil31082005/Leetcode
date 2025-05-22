import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i = 1; i <= n - 2; i++){
            if(num.charAt(0) == '0' && i > 1){
                break;
            }
            BigInteger num1 = new BigInteger(num.substring(0, i));

            for(int j = 1; i + j < n; j++){
                if(num.charAt(i) == '0' && j > 1){
                    break;
                }

                BigInteger num2 = new BigInteger(num.substring(i, i + j));

                if(isValid(num, num1, num2, i + j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValid(String num, BigInteger num1, BigInteger num2, int idx){
        if(idx == num.length()){
            return true;
        }
        BigInteger sum = num1.add(num2);
        String sumStr = String.valueOf(sum);

        if (!num.substring(idx).startsWith(sumStr)) {
            return false;
        }
        return isValid(num, num2, sum, idx + sumStr.length());
    }
}