class Solution {
    long cost = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] tree = new ArrayList[n];
        for(int i=0; i<n; i++) tree[i] = new ArrayList<>();
        for(int[] road : roads) {
            tree[road[0]].add(road[1]);
            tree[road[1]].add(road[0]);
        }
        
        for(int k : tree[0]) {
            dfs(tree, seats, k, 0);
        }
        return cost;
    }
    
    int dfs(List<Integer>[] tree, int seats, int node, int prev) {
        if(tree[node].size() == 1) {
            cost++;
            return 1;
        }
        
        int people = 1;
        for(int k : tree[node]) {
            if(k == prev || k == 0) continue;
            people += dfs(tree, seats, k, node);
        }
        
        cost += people/seats + (people%seats == 0 ? 0 : 1);
        return people;
    }
}