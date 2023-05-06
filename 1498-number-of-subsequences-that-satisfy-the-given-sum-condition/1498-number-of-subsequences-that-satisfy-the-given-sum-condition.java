class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1,count=0,mod=(int)1e9 + 7;
        int[] power=new int[nums.length];
        power[0]=1; 
        for(int idx=1;idx<nums.length;idx++)
            power[idx]=(power[idx-1]*2)%mod;  
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                count=(count+power[j-i])%mod;
                i++;
            }else if(nums[i]+nums[j]>target)
                j--;
        }
        return count;
    }
}