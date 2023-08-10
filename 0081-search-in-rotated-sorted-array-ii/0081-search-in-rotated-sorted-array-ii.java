class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1, min = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(l!=r && nums[l]==nums[r])
                l++;
            else if(nums[mid]==target)
                return true;
            else if(nums[mid]>=nums[l]){
                if(nums[mid]>=target && target>=nums[l])
                    r = mid-1;
                else
                    l = mid+1;
            }
            else{
                if(nums[mid]<=target && target<=nums[r])
                    l = mid+1;
                else
                    r = mid-1;
            }
        }
        return false;
    }
}