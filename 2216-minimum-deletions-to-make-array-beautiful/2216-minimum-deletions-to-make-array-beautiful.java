class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length, x = 0, count = 0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1] && x%2==0)
                count++;
            else
                x++;
        }
        if(x%2==0)
            count++;
        return count;
    }
}