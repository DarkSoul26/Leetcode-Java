class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            visit[nums[i]-1] = true;
        }
        for(int i=0;i<nums.length;i++){
            if(!visit[i])
                ans.add(i+1);
        }
        return ans;
    }
}