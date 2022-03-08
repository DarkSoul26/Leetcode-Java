class Solution {
    public long minimalKSum(int[] nums, int k) {
        long sum = (k * (long)(k+1))/2;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] <= k){
                sum -= nums[i];
                k++;
                sum += k;
            }else break;
        }
        return sum;
    }
}