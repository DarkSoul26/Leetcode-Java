class Solution {
    public boolean canJump(int[] nums) {
        int res = -1;
        
        for(int i=0;i<nums.length-1;i++){
            res = Math.max(i+nums[i]-1, res);
            if(res<i)
                return false;
        }
        return true;
    }
}