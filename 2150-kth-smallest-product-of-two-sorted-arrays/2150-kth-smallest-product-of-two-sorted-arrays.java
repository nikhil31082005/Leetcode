class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = -1000_000_0001l;
        long hi = 1000_000_0001l;
        long ans = 0;
        while(lo<=hi){
            long mid = (lo+hi)/2;
            if(countProd(nums1, nums2, mid)>=k){
                ans = mid;
                hi = mid -1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
    public long countProd(int[] nums1, int[] nums2, long dot_pro){
        long ans = 0;
        for(int e1 : nums1){
            long c = 0;
            int lo = 0;
            int hi = nums2.length-1;
            if(e1>=0){
                while(lo<=hi){
                    int mid = lo+((hi-lo)/2);
                    if((long)e1*nums2[mid]<=dot_pro){
                        c = mid+1;
                        lo = mid + 1;
                    }else{
                        hi = mid-1;
                    }
                }
                ans += c;
                
            }else{
                while(lo<=hi){
                    int mid = (lo+hi)/2;
                    if((long)e1*nums2[mid]<=dot_pro){
                        c = nums2.length - mid;
                        hi  = mid - 1;
                    }else{
                        lo = mid+1;
                    }
                }
                ans += c;
            }
        }
        return ans;
    }
}