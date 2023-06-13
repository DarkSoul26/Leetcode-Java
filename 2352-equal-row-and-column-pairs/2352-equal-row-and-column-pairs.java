class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        Map<String, Integer> hm = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid.length;j++){
                sb.append(grid[i][j]+" ");
            }
            if(hm.containsKey(sb.toString()))
                hm.put(sb.toString(), hm.get(sb.toString())+1);
            else
                hm.put(sb.toString(), 1);
        }
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<grid.length;j++){
                sb.append(grid[j][i]+" ");
            }
            if(hm.containsKey(sb.toString()))
                count+=hm.get(sb.toString());
        }
        return count;
    }
}