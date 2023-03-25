class Solution {
    List<List<Integer>> x = new ArrayList<>();
    public long countPairs(int n, int[][] edges) {
        for(int i=0; i<n; i++)
            x.add(new ArrayList<>());
        for(int [] edge : edges){
            x.get(edge[0]).add(edge[1]); 
            x.get(edge[1]).add(edge[0]);
        }

        long res = 0, sum = n;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++)
            if(!visited[i]){
                int curr = dfs(i, visited, new int[1]); 
                sum = sum-curr;
                res += curr*sum;
            }
        return res;
    }

    int dfs(int node, boolean[] visited, int[] count){ 
        if(visited[node]) return count[0];
        visited[node] = true;
        count[0]++;
        for(int curr : x.get(node))
            dfs(curr, visited, count);
        return count[0];
    }
}