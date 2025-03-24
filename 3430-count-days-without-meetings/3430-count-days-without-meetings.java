class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> {
            return a[0] - b[0];
        });

        int c = 0;
        int start = 1;
        for(int[] arr: meetings){
            if(arr[0] > start){
                c += arr[0] - start;
                start = arr[1] + 1;
            }
            else{
                start = arr[1] + 1;
            }
        }
        if(start <= days){
            c += days - start + 1;
        }
        return c;
    }
}