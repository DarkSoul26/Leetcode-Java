class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int rep1 = 0;
        int rep2 = 0;
        int index = nums.length - 1;
        int n = nums.length - 1;
        int min = n;
        for(int i = nums.length - 2; i >= 0 ; i--){
            if(nums[i] == nums[i + 1]){
                rep1++;
            }
            while(index >= 0 && nums[index] > nums[i] + n){
                if(nums[index - 1] == nums[index]){
                    rep2++;
                }
                index--;
            }

            min = Math.min(( n + 1 - ( index - i  + 1 )) +  rep1 - rep2, min);

        }
        return min;
    }
}