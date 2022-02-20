class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int remove = 0;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] == -1){
                continue;
            }
            for(int j = 0; j < intervals.length; j++){
                if(i == j){
                    continue;
                }
                if(intervals[j][0] >= intervals[i][0] && intervals[j][1] <= intervals[i][1]){
                    intervals[j][0] = -1;
                    intervals[j][1] = -1;
                    remove++;
                }
            }
        }
        return intervals.length-remove;
    }
}