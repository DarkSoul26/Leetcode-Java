class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int count = 0;
        int n = nums.length;
        int l = 0, r = 0;
        int prod = 1;
        while(r<n){
            prod*=nums[r];
            while(prod>=k) prod/=nums[l++];
            count+=1+r-l;
            r++;
        }
        // count+=(r-l)*(r-l-1)/2;
        // for(int i=0;i<n;i++){
        //     int prod = 1;
        //     for(int j=i;j<n;j++){
        //         prod*=nums[j];
        //         if(prod<k) count++;
        //         else break;
        //     }
        // }
        return count;
    }
}