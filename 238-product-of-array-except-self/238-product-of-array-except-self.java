class Solution {
    public int[] productExceptSelf(int[] nums) {
        long prod = 1;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                prod*=nums[i];
            if(nums[i]==0)
                count++;
        }
        if(count>=2){
            Arrays.fill(nums,0);
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(count!=0)
                    nums[i] = 0;
                else
                    nums[i] = (int)prod/nums[i];
            }
            else{
                nums[i] = (int)prod;
            }
        }
        return nums;
    }
}