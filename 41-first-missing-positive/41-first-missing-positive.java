class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean one = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1)
                one = true;
            if(nums[i]<=0 || nums[i]>nums.length)
                nums[i] = 1;
        }
        if(!one)
            return 1;
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            if(nums[i]<0)
                x = -nums[i];
            nums[x-1] = -Math.abs(nums[x-1]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return i+1;
        }
        return nums.length+1;
    }
}