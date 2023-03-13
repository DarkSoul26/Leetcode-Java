class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        long ans = 0;
        // if(nums[nums.length-1]>0)
        //     count++;
        for(int i=nums.length-1;i>=0;i--){
            ans = ans+nums[i];
            if(ans>0)
                count++;
        }
        return count;
    }
}