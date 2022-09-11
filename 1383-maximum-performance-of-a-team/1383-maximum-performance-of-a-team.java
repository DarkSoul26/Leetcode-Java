class Solution {
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        int[][] eng = new int[n][2];
        for (int i = 0; i < n; ++i)
            eng[i] = new int[] {eff[i], speed[i]};
        
        Arrays.sort(eng, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long res = 0, speedSum = 0;
        for (int[] engineer : eng) {
            int e = engineer[0], s = engineer[1];
            minHeap.add(s);
            speedSum += s;
            if (minHeap.size() > k) { 
                speedSum -= minHeap.poll();
            }
            res = Math.max(res, (speedSum * e));
        }
        return (int) (res % (long)(1000000007));
    }
}