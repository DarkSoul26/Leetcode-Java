class Solution {
    
    HashSet<Integer> visited = new HashSet<>();
    public int countCompleteComponents(int n, int[][] edges) {
        int m = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<m;i++){
            int j = edges[i][0];
            int k = edges[i][1];
            adjList.get(j).add(k);
            adjList.get(k).add(j);
        }
        
        int comps = 0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                // comps++;
                // int edge = 0, vert = 1;
                int[] c = {0, 0};
                countCompo(c, i, edges, adjList);
                // System.out.println(i+" "+c[0]+" "+c[1]);
                if(c[0] == c[1]*(c[1]-1))
                    comps++;
            }
        }
        
        return comps;
    }
    
    public void countCompo(int[] c, int i, int[][] edges, List<List<Integer>> adjList){
        if(visited.contains(i))
            return;
        visited.add(i);
        c[0] += adjList.get(i).size();
        c[1]++;
        for(int j=0;j<adjList.get(i).size();j++){
            // ++c[0];
            if(!visited.contains(adjList.get(i).get(j))){
                countCompo(c, adjList.get(i).get(j), edges, adjList);
            }
        }
    }
}