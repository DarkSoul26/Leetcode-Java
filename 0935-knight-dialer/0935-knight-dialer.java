class Solution {
    private final static long mod = (long) Math.pow(10, 9) + 7;
    long[][][] res;
    public int knightDialer(int N) {
        res = new long[N+1][4][3];
        long s = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                s = (s + dfs(i, j, N)) % mod;
            }
        }
        return (int) s;
    }
    
    private long dfs(int i, int j, int cnt) {
        if (i < 0 || j < 0 || j > 2 || i > 3 || (i == 3 && j != 1)) return 0;
        if (res[cnt][i][j] > 0) return res[cnt][i][j];
        if (cnt == 1) return 1;
        res[cnt][i][j] = (dfs(i + 2, j + 1, cnt - 1)
            + dfs(i - 2, j + 1, cnt - 1)
            + dfs(i + 2, j - 1, cnt - 1)
            + dfs(i - 2, j - 1, cnt - 1)
            + dfs(i + 1, j + 2, cnt - 1)
            + dfs(i - 1, j + 2, cnt - 1)
            + dfs(i + 1, j - 2, cnt - 1)
            + dfs(i - 1, j - 2, cnt - 1)) % mod;
        return res[cnt][i][j];        
    }
}