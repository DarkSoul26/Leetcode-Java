class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        double sum = 0;
        for(int i=0;i<nums.length;i++){
            pq.add((double)nums[i]);
            sum+=(double)nums[i];
        }
        double halfSum = sum;
        int c = 0;
        while(halfSum>sum/2){
            double x = pq.remove()/2;
            halfSum-=x;
            pq.add(x);
            c++;
        }
        return c;
    }
}