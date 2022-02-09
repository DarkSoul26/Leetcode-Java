class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>(); 
        int n = nums.length;
        for(int i = 0; i < nums.length - 1; i++){
            if(Arrays.binarySearch(nums, i + 1, n, nums[i] + k) > 0){
                set.add(nums[i]);
            }
        }
        return set.size();
    }
}