class Solution {
        public int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        HashMap<Integer, HashSet<Integer>> to_routes = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j : routes[i]) {
                if (!to_routes.containsKey(j))
                    to_routes.put(j, new HashSet<Integer>());
                to_routes.get(j).add(i);
            }
        }
        Queue<int[]> bfs = new ArrayDeque();
        bfs.offer(new int[] {S, 0});
        HashSet<Integer> seen = new HashSet<>();
        seen.add(S);
        boolean[] seen_routes = new boolean[n];
        while (!bfs.isEmpty()) {
            int stop = bfs.peek()[0], bus = bfs.peek()[1];
            bfs.poll();
            if (stop == T) return bus;
            for (int i : to_routes.get(stop)) {
                if (seen_routes[i]) continue;
                for (int j : routes[i]) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        bfs.offer(new int[] {j, bus + 1});
                    }
                }
                seen_routes[i] = true;
            }
        }
        return -1;
    }
}