class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> arrSeq = new HashMap<Integer,Integer>();
        int n = arr.length;
        int ans = 0;
        int newLen;
        for(int i=0;i<n;i++) {
            newLen = arrSeq.getOrDefault(arr[i]-difference, 0) + 1;
            arrSeq.put(arr[i],newLen);
            ans = Math.max(ans,newLen);
        }
        return ans;
    }
}