class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            return a[0] - b[0];
        });
        for(int[] arr: meetings){
            System.out.println(arr[0] + " " + arr[1]);
        }

        int count = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<meetings.length;i++){
            if(meetings[i][0] > end){
                count += meetings[i][0] - end - 1;
                end = Math.max(end,meetings[i][1]);
            }
            else{
                end = Math.max(end,meetings[i][1]);
            }
        }
        if(days > end){
            count += days - end;
        }
        return count;
    }
}