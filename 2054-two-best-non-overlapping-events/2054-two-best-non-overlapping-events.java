class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events,(a,b) -> {
           if(a[1] == b[1]) return a[0]-b[0];
           return a[1]-b[1];
        });
        
        int[] maxArray = new int[events.length];
        int max = 0, p = 0;
        for(int[] i : events){
            max = Math.max(i[2],max);
            maxArray[p++] = max;
        }
        
        TreeMap<Integer,int[]> maps = new TreeMap<>(); //values: 0 idx - node; 1 idx - high value at that endtime;
        maps.put(events[0][1],new int[]{0,events[0][2]});
        
       
        int maxRes = 0;
        for(int i = 0; i < events.length; i++){
            
             if(maps.lowerKey(events[i][0]) == null){
                    int v = maps.getOrDefault(events[i][1],new int[]{0,0})[1];
                    if(v < events[i][2])
                    maps.put(events[i][1],new int[]{i,events[i][2]});
                    maxRes = Math.max(maxRes,events[i][2]);
             }
            else{
                    int v = maps.getOrDefault(events[i][1],new int[]{0,0})[1];
                    int[] a = maps.get(maps.lowerKey(events[i][0]));
                    if(v < maxArray[a[0]] + events[i][2])
                    maps.put(events[i][1],new int[]{i,maxArray[a[0]] + events[i][2]});
                    maxRes = Math.max(maxRes,maxArray[a[0]] + events[i][2]);
            }
        }
        return maxRes;
        
    }
}