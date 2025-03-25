class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> {
            return a[0] - b[0];
        });

        boolean ans = false;
        int end_x = 0;
        int s = -1;
        for(int[] arr: rectangles){
            if(arr[0] < end_x){
                end_x = Math.max(end_x, arr[2]);
            }
            else{
                s++;
                end_x = Math.max(end_x, arr[2]);
            }
        }
        System.out.println(s);
        if(s >= 2){
            return true;
        } 

        Arrays.sort(rectangles, (a, b) -> {
            return a[1] - b[1];
        });

        int end_y = 0;
        s = -1;
        for(int[] arr: rectangles){
            if(arr[1] < end_y){
                end_y = Math.max(end_y, arr[3]);
            }
            else{
                s++;
                end_y = Math.max(end_y, arr[3]);
            }
        }
        System.out.println(s);
        if(s >= 2){
            return true;
        }
        return false;
    }
}