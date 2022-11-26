class Triple{
    int st;
    int et;
    int prf;
    Triple(int st, int et, int prf){
        this.st = st;
        this.et = et;
        this.prf = prf;
    }
}
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        List<Triple> t = new ArrayList<>();
        for(int i=0;i<startTime.length;i++)
            t.add(new Triple(startTime[i], endTime[i], profit[i]));
        
        Collections.sort(t, new Comparator<Triple>(){
            public int compare(Triple a, Triple b){
                return a.et-b.et;
            }
        });
        int max = Integer.MIN_VALUE;
        for(Triple triple: t){
        
            Integer x = tm.floorKey(triple.st);
            Integer maxV = x == null ? 0 : tm.get(x);
            
            max = Math.max(max, maxV+triple.prf);
            tm.put(triple.et, max);
            
        }
        return max;
    }
}