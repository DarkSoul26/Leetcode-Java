class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(mid>0 && mid<nums.length-1){
                if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid])
                    return mid;
                else if(nums[mid]<nums[mid+1])
                    l = mid+1;
                else
                    r = mid;
            }
            else{
                if(mid == 0){
                    if(nums[0]>nums[1])
                        return 0;
                    return 1;
                }
                if(mid == nums.length-1){
                    if(nums[nums.length-1]>nums[nums.length-2])
                        return nums.length-1;
                    return nums.length-2;
                }
            }
        }
        return -1;
    }
}