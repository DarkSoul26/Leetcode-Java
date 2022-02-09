class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0, len = nums.length;
        List<List<Integer>> al = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            sum = nums[i];
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int j = i+1;
            int k = len-1;
            int temp;
            while(j<k){
                temp = sum+nums[j]+nums[k];
                if(temp==0){
                    al.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // List<Integer> al1 = new ArrayList<>();
                    // al1.add(nums[i]);
                    // al1.add(nums[j]);
                    // al1.add(nums[k]);
                    // if(!al.contains(al1))
                    //     al.add(al1);
                    // j++;
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                else if(temp>0)
                    k--;
                else
                    j++; 
            }
        }
        return al;
    }
}