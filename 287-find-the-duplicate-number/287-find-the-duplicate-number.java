class Solution {
    public int findDuplicate(int[] nums) {
        int r = nums.length;
        for(int i=0;i<r;i++){
            int abs = Math.abs(nums[i]);
            if(nums[abs]<0)
                return abs;
            else{
                nums[abs] = -nums[abs];
            }
        }
        return -1;
    }
}