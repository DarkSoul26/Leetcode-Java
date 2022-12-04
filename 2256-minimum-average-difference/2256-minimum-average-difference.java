class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0, sum1 = 0;
        for(int num: nums){
            sum+=num;
        }
        
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<nums.length-1;i++){
            sum1+=nums[i];
            if(Math.abs((int)((sum1/(i+1)) - (sum-sum1)/(nums.length-i-1)))<min){
                ans = i;
                min = Math.abs((int)((sum1/(i+1)) - (sum-sum1)/(nums.length-i-1)));
            }
        }
        if(min>sum/nums.length){
            ans = nums.length-1;
        }
        return ans;
    }
}