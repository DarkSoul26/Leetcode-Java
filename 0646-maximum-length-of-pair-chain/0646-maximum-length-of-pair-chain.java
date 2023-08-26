class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 1;
        int last = pairs[0][1]; // last value of picked chain
        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > last) { // if no overlap, we can pick this as part of chain
                res++;
                last = pairs[i][1];
            }
        }
        return res;
    }
}