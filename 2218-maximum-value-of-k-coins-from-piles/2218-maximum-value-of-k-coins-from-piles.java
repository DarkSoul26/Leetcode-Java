class Solution {
     public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] coin_collection = new int[piles.size() + 1][k + 1];
        
        return dp(piles, coin_collection, 0, k);
    }
    public int dp(List<List<Integer>> piles, int[][] coin_collection, int i, int k) {
        if (k == 0 || i == piles.size()) return 0;
        if (coin_collection[i][k] != 0) return coin_collection[i][k];

        int res = dp(piles, coin_collection, i + 1, k);
        int cur = 0;

        for (int j = 0; j < Math.min(piles.get(i).size(), k); ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, cur + dp(piles, coin_collection, i + 1, k - j - 1));
        }
        return coin_collection[i][k] = res;
    }
}