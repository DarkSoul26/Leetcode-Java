class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                temp++;
            }
            else {
                ans+=temp*(temp+1)/2;
                temp = 0;
            }
        }
        ans+=temp*(temp+1)/2;
        return ans;
    }
}