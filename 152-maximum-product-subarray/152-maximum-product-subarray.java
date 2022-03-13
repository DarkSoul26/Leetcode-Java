class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp = min;
                min = max;
                max = temp;
            }
            
            min = Math.min(min*nums[i], nums[i]);
            max = Math.max(max*nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}