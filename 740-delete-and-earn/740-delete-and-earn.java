class Solution {
    public int deleteAndEarn(int[] nums) {
        int dp[] = new int[10002];
        int a[][] = new int[10002][2];
        for(int i = 0;i<nums.length;i++){
            a[nums[i]][1]++;
        }
        dp[1] = Math.max(dp[0], 1*a[1][1]);
        for(int i=2;i<=10001;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+i*a[i][1]);
        }
        return dp[10001];
//         Map<Integer, Integer> m = new HashMap<>();
//         for(int i=0;i<nums.length;i++)
//             m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
//         while(true){
//             int minEl;
//             for(Map.Entry ml: m.entrySet()){
                
//             }
//         }
    }
}