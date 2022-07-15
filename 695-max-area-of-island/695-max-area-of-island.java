class Solution {
    boolean [][] visited;
    int c=0;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        List<Integer> al = new ArrayList<>();
        al.add(0);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    c=1;
                    visited[i][j]=true;
                    count(grid,i,j);
                    al.add(c);
                }
            }
        }
        return Collections.max(al);
    }
    
    public void count(int[][] grid,int i,int j){
        if(j!=grid[0].length-1 && !visited[i][j+1] && grid[i][j+1]==1){
            visited[i][j+1]=true;
            count(grid,i,j+1);
            c+=1;
        }
        if(i!=grid.length-1 && !visited[i+1][j] && grid[i+1][j]==1){
            visited[i+1][j]=true;
            count(grid,i+1,j);
            c+=1;
        }
        if(i!=0 && !visited[i-1][j] && grid[i-1][j]==1){
            visited[i-1][j]=true;
            count(grid,i-1,j);
            c+=1;
        }
        if(j!=0 && !visited[i][j-1] && grid[i][j-1]==1){
            visited[i][j-1]=true;
            count(grid,i,j-1);
            c+=1;
        }
        return;
    }
}