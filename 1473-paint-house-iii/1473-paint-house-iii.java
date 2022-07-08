class Solution {
    Long[][][] memo;
    int[] houses; int[][] cost;
    int m; int n;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.memo = new Long[m + 1][n + 1][target + 1]; this.houses = houses; this.cost = cost;
        this.m = m; this.n = n;
        int res = (int)dfs(0, 0, target);  //(curIndex, prevColor, numberOfBlocksLeft);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private long dfs(int cur, int preColor, int target) {
        if (target < 0) return Integer.MAX_VALUE;
        if (cur == m && target == 0) return 0;
        if (cur == m) return Integer.MAX_VALUE;
        if (preColor >= 0 && memo[cur][preColor][target] != null) return memo[cur][preColor][target];
        long minCost = Integer.MAX_VALUE;
        if (houses[cur] == 0) {
            for (int curColor = 1; curColor <= n; curColor++)
                if (curColor == preColor)
                    minCost = Math.min(minCost, cost[cur][curColor - 1] + dfs(cur + 1, curColor, target));
                else
                    minCost = Math.min(minCost, cost[cur][curColor - 1] + dfs(cur + 1, curColor, target - 1));
        } else {
            if (houses[cur] == preColor) minCost = Math.min(minCost, dfs(cur + 1, houses[cur], target));
            else minCost = Math.min(minCost, dfs(cur + 1, houses[cur], target - 1));
        }
        return memo[cur][preColor][target] = minCost;
    }
}