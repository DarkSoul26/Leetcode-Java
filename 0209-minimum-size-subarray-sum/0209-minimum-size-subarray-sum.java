class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,min = Integer.MAX_VALUE,sum=0;
        while(j<nums.length){
            if(j<nums.length && sum<target){
                sum+=nums[j];
                    j++;
            }
            while(sum>=target){
                if(min>j-i)
                    min = j-i;
                sum-=nums[i];
                i++;
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}