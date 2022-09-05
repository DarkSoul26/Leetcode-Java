class Solution {
    public int minimumDeletions(int[] nums) {
        int minInd = 0, minNum = nums[0];
        int maxInd = 0, maxNum = nums[0];
        
        for(int i=0;i<nums.length;i++){
            if(minNum>nums[i]){
                minNum = nums[i];
                minInd = i;
            }
            if(maxNum < nums[i]){
                maxNum = nums[i];
                maxInd = i;
            }
        }
        return Math.min(Math.min(Math.max(maxInd+1, minInd+1), nums.length - Math.min(maxInd, minInd)), Math.min(maxInd, minInd)+1+nums.length-Math.max(maxInd, minInd));
    }
}