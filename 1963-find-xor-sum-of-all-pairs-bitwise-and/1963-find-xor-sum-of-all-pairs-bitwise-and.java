class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int a = 0;
        for(int ele: arr1){
            a ^= ele;
        }
        int b = 0;
        for(int ele: arr2){
            b ^= ele;
        }
        return a & b;
    }
}