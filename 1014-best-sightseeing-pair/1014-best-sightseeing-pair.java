class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = -1, maxAti = values[0];
        for(int i=1;i<values.length;i++){
            ans = Math.max(ans, maxAti+values[i]-i);
            maxAti = Math.max(maxAti, values[i]+i);
        }
        return ans;
    }
}