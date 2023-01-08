class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3)
            return points.length;
        Map<Double, Integer> map = new HashMap();
        int result = 0;
        for (int i = 0; i <points.length; i++){
            map = new HashMap();
            for (int j = 0; j<points.length;j++){
            if (i!=j){
                Double slope = calculateSlope(points[i], points[j]);
                map.put(slope, map.getOrDefault(slope, 1)+1);
            }
            }
            for(Double d: map.keySet())
                result = Math.max(result, map.get(d));
        }
        return result;  
    }
    private Double calculateSlope(int[] p1, int[] p2){
        Double xDiff= Double.valueOf(p2[0] -p1[0]);
        Double yDiff= Double.valueOf(p2[1] - p1[1]);
        if (xDiff == 0)
            return Double.MAX_VALUE;
        return yDiff/xDiff;
    }
}