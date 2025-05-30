class Solution {
    public int findSpecialInteger(int[] arr) {
        if(arr.length==1) return arr[0];
        int c = 1;
        int k = arr.length/4;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                c++;
                if(c > k){
                    return arr[i];
                }
            }
            else{
                c = 1;
            }
        }
        return -1;
    }
}