class Solution {
    public int longestArithSeqLength(int[] A) {
        int ansMax = 0, n = A.length, was, diff;
        HashMap<Integer, Integer> tillI[] = new HashMap[n];
        for(int i = 0; i < n; ++i)
            tillI[i] = new HashMap<>();
        
        for(int i = 1; i < n; ++i)
            for(int j = 0; j < i; ++j) {
                diff = A[i] - A[j];
                was = tillI[j].getOrDefault(diff, 1);  
                ansMax = Math.max(was + 1, ansMax);
                tillI[i].put(diff, was + 1);   
            }
        return ansMax;
    }
}