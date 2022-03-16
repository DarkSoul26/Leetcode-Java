class Solution {
     public int getMaxLen(int[] nums) {
        int firstNegative = -1, zeroPosition = -1, sum = 0, max = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] < 0){
                sum++;
                if(firstNegative == -1) firstNegative = i;
            }
            if(nums[i] == 0){
                sum = 0;
                firstNegative = -1;
                zeroPosition = i;
            }
            else{
                if(sum%2 == 0) max = Math.max(i - zeroPosition, max);
                else max = Math.max(i - firstNegative, max);   
            }
        }
        return max;
    }
}