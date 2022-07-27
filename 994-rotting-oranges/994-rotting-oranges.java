class Solution {
    public int orangesRotting(int[][] grid) {
        int countOr = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    q.add(new Pair(i,j));
                if(grid[i][j]!=0)
                    countOr++;
            }
        }
        int x[] = new int[]{0,0,-1,1};
        int y[] = new int[]{1,-1,0,0};
        int days= 0, count = 0;
        while(!q.isEmpty()){
            count += q.size();
            int k = q.size();
            while(k--!=0){
                
                Pair pair = q.remove();
                for(int i=0;i<4;i++){
                    int x1 = (int)pair.getKey()+x[i];
                    int y1 = (int)pair.getValue()+y[i];

                    if(x1<0 || y1<0 || x1>=grid.length || y1>=grid[0].length || grid[x1][y1] !=1)
                        continue;
                    grid[x1][y1] = 2;
                    q.add(new Pair(x1, y1));
                }
            }
            if(!q.isEmpty())
                days++;
        }   
        // System.out.println(count+" "+countOr);
        if(count == countOr)
            return days;
        return -1;
    }
}