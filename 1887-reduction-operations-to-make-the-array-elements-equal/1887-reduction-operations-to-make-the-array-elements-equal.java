class Solution {
    public int reductionOperations(int[] nums) {
        int steps = 0;
        Arrays.sort(nums);
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i] < nums[i+1]){
                steps += nums.length-1-i;
            }
        }
        return steps;
    }
}