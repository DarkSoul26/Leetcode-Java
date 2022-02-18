class Solution {
    
    public static void dfs(char[][] graph, boolean[][] isVisited, int i, int j, int n, int m){
      isVisited[i][j] = true;
      if(i<n-1){
        if(!isVisited[i+1][j] && graph[i+1][j] == '1')
          dfs(graph, isVisited, i+1, j, n, m);
      }
      if(j<m-1){
        if(!isVisited[i][j+1] && graph[i][j+1] == '1')
          dfs(graph, isVisited, i, j+1, n, m);
      }
      if(j>0){
        if(!isVisited[i][j-1] && graph[i][j-1] == '1')
          dfs(graph, isVisited, i, j-1, n, m);
      }
      if(i>0){
        if(!isVisited[i-1][j] && graph[i-1][j] == '1')
          dfs(graph, isVisited, i-1, j, n, m);
      }
    }
    public static int dft(char[][] graph, boolean[][] isVisited, int n, int m){
      int count = 0;
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
          if(!isVisited[i][j] && graph[i][j]=='1'){
            count++;
            dfs(graph, isVisited, i, j, n, m);
          }
        }
      }
      
      return count;
    }
    
    public int numIslands(char[][] graph) {
      int n = graph.length;
      int m = graph[0].length;
      boolean isVisited[][] = new boolean[n][m];
      int noOfKingdoms = dft(graph, isVisited, n, m);
      return noOfKingdoms;
    }
}