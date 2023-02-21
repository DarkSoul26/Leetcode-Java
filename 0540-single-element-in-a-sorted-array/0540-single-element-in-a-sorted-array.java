class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1, mid = -1;
        while(l<r){
            mid = l+(r-l)/2;
            
            if(mid%2==0){
                if(nums[mid+1]==nums[mid])
                    l = mid+1;
                else
                    r = mid;
            }
            else{
                if(nums[mid+1]==nums[mid])
                    r = mid;
                else
                    l = mid+1;
            }
        }
        return nums[l];
    }
}