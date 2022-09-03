class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] ind = new int[k];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> al = new ArrayList<>(k);
        for(int i=0;i<k;i++)
            al.add(new ArrayList<>());
        for(int i=0;i<rowConditions.length;i++){
            al.get(rowConditions[i][0]-1).add(rowConditions[i][1]-1);
            ind[rowConditions[i][1]-1]++;
        }
        for(int i=0;i<k;i++){
            if(ind[i] == 0)
                q.offer(i);
        }
        int row[] = new int[k];
        int col[] = new int[k];
        int count = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            row[x] = count++;
            for(int y: al.get(x)){
                // ind[y]--;
                if(--ind[y] == 0){
                    q.offer(y);
                }
            }
        }
        if(count!=k)
            return new int[0][0];
        
        al.clear();
        Arrays.fill(ind, 0);
        
        for(int i=0;i<k;i++)
            al.add(new ArrayList<>());
        for(int i=0;i<colConditions.length;i++){
            al.get(colConditions[i][0]-1).add(colConditions[i][1]-1);
            ind[colConditions[i][1]-1]++;
        }
        for(int i=0;i<k;i++){
            if(ind[i] == 0)
                q.offer(i);
        }
        // int row[] = new int[k];
        // int col[] = new int[k];
        // Arrays.fill(row, 0);
        // Arrays.fill(col, 0);
        count = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            col[x] = count++;
            for(int y: al.get(x)){
                // ind[y]--;
                if(--ind[y] == 0){
                    q.offer(y);
                }
            }
        }
        if(count!=k)
            return new int[0][0];
        int[][] ans = new int[k][k];
        for(int i=0;i<k;i++){
            ans[row[i]][col[i]] = i+1;
        }
        
        return ans;
    }
}