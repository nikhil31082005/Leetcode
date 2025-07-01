class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int count = 0;


        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });

        // for(int[] arr: boxTypes){
        //     System.out.println(Arrays.toString(arr));
        // }


        for(int[] arr: boxTypes){
            // System.out.print(truckSize + " ");
            if(arr[0] <= truckSize){
                count += arr[0] * arr[1];
                truckSize -= arr[0];
            }
            else{
                count += (truckSize) * arr[1];
                truckSize = 0;
            }
        }
        return count;
    }
}