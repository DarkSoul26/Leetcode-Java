class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        for(int i = 0; i<=nums.length-3; i++){
            int j = i+1;
            int diff = nums[j] - nums[i];
            int count = 2;
			
            while(j+1<nums.length && (nums[j+1]-nums[j]==diff)){
                j++;
                count++;
                if(count>=3){
                    ans++;
                }
            }
        }
        return ans;
    }
}