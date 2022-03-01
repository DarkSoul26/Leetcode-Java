class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        // List<List<Integer>> al = new ArrayList<>();
        int n = intervals.length;
        int l = 0, r = 1;
        int count = 0;
        while(r<n){
            if(intervals[l][1]<=intervals[r][0]){
                l = r;
                r++;
            }
            else if(intervals[l][1]<=intervals[r][1]){
                count++;
                r++;
            }
            else if(intervals[l][1]>intervals[r][1]){
                count++;
                l = r;
                r++;
            }
        }
        return count;
    }
}