class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        if(nums1.length % 2 != 0){
            for(int ele: nums2){
                ans ^= ele;
            }
        }
        if(nums2.length % 2 != 0){
            for(int ele: nums1){
                ans ^= ele;
            }
        }
        return ans;
    }
}