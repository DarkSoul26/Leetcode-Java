class Solution {
    public void dfs(List<List<Integer>> graph, int n, boolean[] isVisited, int j){
        if(isVisited[j])
            return;
        isVisited[j] = true;
        int n2;
        for(int i=0;i<graph.get(j).size();i++){
            dfs(graph, n, isVisited, graph.get(j).get(i));
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j] == 1){
                    graph.get(i).add(j);
                    // graph.get(j).add(i);
                }
            }
        }
        boolean isVisited[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                dfs(graph, n, isVisited, i);
                count++;
            }
        }
        return count;
    }
}