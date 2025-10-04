class Solution {
    public int maxArea(int[] arr) {
       int n = arr.length;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = n - 1;
        int maxArea = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);

            if (leftMax < rightMax) {
                maxArea = Math.max(maxArea, leftMax * (right - left));
                left++;
            } else {
                maxArea = Math.max(maxArea, rightMax * (right - left));
                right--;
            }
        }

        return maxArea;
    }
}