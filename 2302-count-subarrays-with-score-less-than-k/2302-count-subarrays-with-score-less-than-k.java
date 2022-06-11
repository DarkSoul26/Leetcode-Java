class Solution {
    public long countSubarrays(int[] nums, long k) {
             
        long count = 0;
        int n = nums.length;
        int l = 0, r = 0;
        long prod = 0;
        while(r<n){
            prod+=nums[r];
            while((long)prod*(long)(1+r-l)>=k) prod-=nums[l++];
            count+=(long)r-l+1;
            r++;
        }
        return count;
    }
}