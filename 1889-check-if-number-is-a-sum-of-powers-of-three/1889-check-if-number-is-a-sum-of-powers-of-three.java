class Solution {
    public boolean checkPowersOfThree(int n) {
        return check(0,n);
    }
    public static boolean check(int pow, int n){
        if(n == 0){
            return true;
        }
        if(Math.pow(3, pow) > n){
            return false;
        }
        boolean a = check(pow + 1, n - (int)(Math.pow(3, pow)));
        boolean b = check(pow + 1, n);
        return a || b;
    }
}