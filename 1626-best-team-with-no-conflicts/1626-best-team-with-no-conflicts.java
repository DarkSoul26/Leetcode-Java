class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int team[][] = new int[n][2];
        for(int i=0;i<scores.length;i++){
            team[i][0] = scores[i];
            team[i][1] = ages[i];
        }

        Arrays.sort(team, new Comparator<int []>(){
           public int compare(int[] a, int[] b){
               return a[1] == b[1]?a[0]-b[0]:a[1]-b[1];
           } 
        });

        int dp[] = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            dp[i] = team[i][0];
            for(int j=0;j<i;j++){
                if(team[i][0] >= team[j][0]){
                    dp[i] = Math.max(dp[i], team[i][0]+dp[j]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }
}