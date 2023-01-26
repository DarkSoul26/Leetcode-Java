class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { 
        HashMap<Integer, List<int[]>> fMap = new HashMap<>();

        for (int[] f : flights) {
            fMap.putIfAbsent(f[0], new ArrayList<>());
            fMap.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        queue.offer(new int[]{0, src, k + 1});
        HashMap<Integer, Integer> visited = new HashMap<>();

        while (!queue.isEmpty()) {
            int[] e = queue.poll();
            int cost = e[0], steps = e[2], cur = e[1];
            if(visited.containsKey(cur) && visited.get(cur)>=steps) // avoid TLE
                continue;
            visited.put(cur, steps);

            if (cur == dst) return e[0];
            if (steps > 0) {
                List<int[]> list = fMap.get(cur);
                if (list == null || list.isEmpty()) continue;
                for (int[] f : list) {
                    queue.offer(new int[]{cost + f[1], f[0], steps - 1});
                }
            }
        }
        return -1;
    }
}