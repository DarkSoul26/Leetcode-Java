class Solution {
    public int cutIt(int n, List<Integer> cuts, int i, int j, int[][] dp){
        if(i>j)
            return 0;
        
        int totCost = Integer.MAX_VALUE;
        if(dp[i][j]!=-1)
            return dp[i][j];
        for(int ind = i;ind<=j;ind++){
            int cost = cuts.get(j+1)-cuts.get(i-1)+cutIt(n, cuts, i, ind-1, dp)+cutIt(n, cuts, ind+1, j, dp);
            totCost = Math.min(totCost, cost);
        }
        
        return dp[i][j] = totCost;
    }
    public int minCost(int n, int[] cuts) {
        
        List<Integer> stick = new ArrayList<>();
        stick.add(0);
        for(int i=0;i<cuts.length;i++){
            stick.add(cuts[i]);
        }
        stick.add(n);
        Collections.sort(stick);
        int c = cuts.length;
        int[][] dp = new int[c+2][c+2];
        
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int totCost = Integer.MAX_VALUE;
                for(int ind = i;ind<=j;ind++){
                    int cost = stick.get(j+1)-stick.get(i-1)+dp[ind+1][j]+dp[i][ind-1];
                    totCost = Math.min(totCost, cost);
                }
                dp[i][j] = totCost;
            }
        }
        return dp[1][c];
        // for(int[] arr: dp)
        //     Arrays.fill(arr, -1);
        // return cutIt(n, stick, 1, cuts.length, dp);
    }
}