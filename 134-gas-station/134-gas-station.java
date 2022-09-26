class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0, total_surplus = 0, start = 0;
        for(int i=0;i<gas.length;++i){
            total_surplus += gas[i]-cost[i];
            surplus += gas[i]-cost[i];
            if(surplus<0){
                start = i+1;
                surplus = 0;
            }
        }
        if(total_surplus<0)
            return -1;
        return start;
    }
}