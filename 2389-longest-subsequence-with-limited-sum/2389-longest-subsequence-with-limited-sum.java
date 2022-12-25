class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int count=0, sum=nums[0];
            for(int j=1;j<nums.length;j++){
                if(sum<=queries[i]){
                    sum+=nums[j];
                    count++;
                    }
                else break;
                }
            if(sum<= queries[i])
                count++;
            ans[i] = count;
        }
        return ans;
    }
}