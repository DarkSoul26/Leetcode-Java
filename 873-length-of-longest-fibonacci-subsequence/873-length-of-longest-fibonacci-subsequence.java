class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int dp[][] = new int[arr.length+1][arr.length+1];
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        for(int[] dp1: dp)
            Arrays.fill(dp1, 2);
        int n = arr.length;
        
        // List<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++)
            m.put(arr[i], i);
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int sec = arr[i]-arr[j];
                if(sec>=arr[j])
                    break;
                
                if(m.containsKey(sec)){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[j][m.get(sec)]);
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }
}