class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int l1 = 0, r1 = nums1.length, mid1 = -1, mid2 = -1;
        double ans = 0;
        int n1 = nums1.length, n2 = nums2.length;
        if(n2<n1)   return findMedianSortedArrays(nums2, nums1);
        while(l1<=r1){
            mid1 = l1+(r1-l1)/2;
            mid2 = (n1+n2+1)/2-mid1;
            // System.out.println(mid1+ " "+ mid2);
            int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int right1 = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1];
            int right2 = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2];
                
            if(left1>right2){
                r1 = mid1-1;
                // l2 = mid2+1;
            }
            else if(left2>right1){
                // r2 = mid2-1;
                l1 = mid1+1;
            }
            else{
                
                if((n1+n2)%2==0){
                    
                    return (Math.max(left1, left2)+Math.min(right1, right2))/2.0;
                    
                    // ans;
                }
                // System.out.println(left1+" "+left2);
                return (double)Math.max(left1, left2); 
                // return ans;
            }
        }
        return 0.0;
    }
}