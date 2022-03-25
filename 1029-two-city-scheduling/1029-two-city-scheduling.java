class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        for(int i=0;i<costs.length;i++){
            sum+=costs[i][0];
        }
        int a[] = new int[costs.length];
        for(int i=0;i<costs.length;i++){
            a[i] = costs[i][1]-costs[i][0];
        }
        Arrays.sort(a);
        for(int i=0;i<costs.length/2;i++)
            sum+=a[i];
        
        return sum;
    }
}