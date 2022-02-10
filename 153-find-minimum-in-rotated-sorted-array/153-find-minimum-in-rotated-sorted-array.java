class Solution {
    public int findMin(int[] nums) {
        int l = 0,r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(mid==nums.length-1)
                return nums[mid];
            else if(mid!=nums.length-1 && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(mid==0)
                return nums[mid];
            else if(mid!=0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid]<nums[l]){
                if(nums[mid]<nums[r])
                    r = mid;
                else
                    l = mid+1;
            }
            else{
                if(nums[l]>nums[r])
                    l = mid+1;
                else
                    r = mid;
            }
                
        }
        return -1;
    }
}