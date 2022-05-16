class Solution {
    int[] row = {0,0,1,-1,1,1,-1,-1};
    int[] col = {1,-1,0,0,1,-1,1,-1};
    int directions = 8;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Cell> q  = new LinkedList();
        if (grid[0][0] == 0) q.add(new Cell(0,0));
        boolean visited[][] = new boolean[m][n];
        visited[0][0] = true;
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i<size; i++) {
                Cell cell = q.poll();
                if (cell.x == m-1 && cell.y == n-1) return count;
                for (int j = 0; j< directions; j++) {
                    int rr = cell.x + row[j];
                    int cc = cell.y + col[j];
                    if (rr < 0 || rr >= m) continue;
                    if (cc < 0 || cc >= n) continue;
                    if (grid[rr][cc] == 1) continue;
                    if (visited[rr][cc]) continue;
                    q.offer(new Cell(rr, cc));
                    visited[rr][cc] = true;
                }
            }
        }
        return -1;
    }
}

class Cell {
    int x;
    int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}