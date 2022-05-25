class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2)
        return 0;
    Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    });
    int dp[] = new int[envelopes.length];
    int len = 0;
    for(int[] envelope : envelopes){
        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
        if(index < 0)
            index = -(index + 1);
        dp[index] = envelope[1];
        if(index == len)
            len++;
    }
    return len;
}
//     public int maxEnvelopes(int[][] envelopes) {
//         Arrays.sort(envelopes, new Comparator<int[]>(){
//             public int compare(int a[], int b[]){
//                 return Integer.compare(a[0], b[0]);
//             }
//         });
        
//         int dp[] = new int[envelopes.length];
//         int ans = 0;
//         // int max = Integer.MIN_VALUE;
//         for(int i=0;i<dp.length;i++){
//             int max = 0;
//             for(int j=0;j<i;j++){
//                 if(envelopes[i][1]>envelopes[j][1] && envelopes[i][0]>envelopes[j][0])
//                     max = Math.max(max, dp[j]);
//             }
//             dp[i] = max+1;
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }
}