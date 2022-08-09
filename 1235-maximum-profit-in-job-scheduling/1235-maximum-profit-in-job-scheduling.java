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
        
        //to store the end time and profit associated with every index
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
            
            //important function associated with treemap i.e. floorkey
            // Integer x = tm.floorKey(triple.st);
            // if(x == null){
            //     max = Math.max(0, max);
            //     tm.put(triple.et, triple.prf);
            // }
            // else{
            //     max = Math.max(tm.get(x)+triple.prf, max);
            //     tm.put(triple.et, tm.get(x)+triple.prf);
            // }
            // max = Math.max(tm.get(triple.et), max);
            Integer x = tm.floorKey(triple.st);
            Integer maxV = x == null ? 0 : tm.get(x);
            
            max = Math.max(max, maxV+triple.prf);
            tm.put(triple.et, max);
            
        }
        return max;
    }
}