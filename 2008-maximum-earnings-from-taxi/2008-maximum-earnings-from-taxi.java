// class Ride{
//     int s;
//     int e;
//     int t;
//     Ride(int s, int e, int t){
//         this.s = s;
//         this.e = e;
//         this.t = t;
//     }
// }
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // for(int i=0;i<rides)
        
        // Ride[] r = new Ride[rides.length];
        // for(int i=0;i<rides.length;i++){
        //     r[i].s = rides[i][0];
        //     r[i].e = rides[i][1];
        //     r[i].t = rides[i][2];
        // }
        Arrays.sort(rides, new Comparator<int[]>(){
            public int compare(int[] r1, int[] r2){
                return r1[1]-r2[1];
            }
        });
        TreeMap<Integer, Long> tm = new TreeMap<>();
        long max = Long.MIN_VALUE;
        for(int[] ride: rides){
            Integer x = tm.floorKey(ride[0]);
            Long y = x == null?0:tm.get(x);
            max = Math.max(max, y+ride[1]-ride[0]+ride[2]);
            tm.put(ride[1], max);
        }
        
        return max;
    }
}