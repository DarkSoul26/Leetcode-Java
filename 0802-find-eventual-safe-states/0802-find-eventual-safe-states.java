class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<Integer>[] adj = new ArrayList[n];
        int[] outdegree = new int[n];
        int[] safe = new int[n];
        List<Integer> ans = new ArrayList();
        Queue<Integer> q = new LinkedList();

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList();

        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                adj[v].add(i);
            }
            outdegree[i] = graph[i].length;
            if (outdegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            safe[u] = 1;
            for (int v : adj[u]) {
                if (--outdegree[v] == 0)
                    q.add(v);
            }
        }
        for (int i = 0; i < n; i++) {
            if (safe[i] == 1)
                ans.add(i);
        }
        return ans;
    }
}