class Graph {

    List<List<int[]>> storeNodes;
    int[] length;
    int size;
    
    public Graph(int size, int[][] edges) {
        this.size = size;
        this.storeNodes = new ArrayList<>();
        for (int i = 0; i < size; i++)
            storeNodes.add(new ArrayList<>());

        for (int[] e : edges) {
            int n1 = e[0];
            int n2 = e[1];
            int weight = e[2];
            storeNodes.get(n1).add(new int[]{n2, weight});
        }
    }
    
    public void addEdge(int[] e) {
            int n1 = e[0];
            int n2 = e[1];
            int weight = e[2];        
            storeNodes.get(n1).add(new int[]{n2, weight});
    }
    
    public int shortestPath(int node1, int node2) {
        length = new int[size];
        Arrays.fill(length, Integer.MAX_VALUE);
        
        length[node1] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(j -> length[j]));
        queue.offer(node1);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] e : storeNodes.get(u)) {
                int v = e[0];
                int w = e[1];
                if (length[v] > length[u] + w) {
                    queue.offer(v);
                    length[v] = length[u] + w;
                }
            }
        }

        return length[node2] != Integer.MAX_VALUE ? length[node2] : -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */