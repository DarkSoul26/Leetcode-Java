class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> top = new Stack<>();
        // iscyclefunc;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++){
            int i1 = prerequisites[i][0];
            int i2 = prerequisites[i][1];
            adj.get(i1).add(i2);
        }
        
        boolean[] isVisit = new boolean[numCourses];
        boolean[] dfsV = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!isVisit[i]){
                // boolean cycleCheck = ;
                if(dfs(i, adj, top, isVisit, dfsV))
                    return new int[0];
            }
        }
        int[] res = new int[top.size()];
        int i = top.size();
        while(!top.isEmpty())
            res[--i] = top.pop();
        
        return res;
    }
    
    public boolean dfs(int i, List<List<Integer>> adj, Stack<Integer> top, boolean[] isVisit, boolean[] dfsV){
        isVisit[i] = true;
        dfsV[i] = true;
        for(int j=0;j<adj.get(i).size();j++){
            if(!isVisit[adj.get(i).get(j)]){
                if(dfs(adj.get(i).get(j), adj, top, isVisit, dfsV))
                    return true;
            }
            else if(dfsV[adj.get(i).get(j)])
                return true;
        }
        top.push(i);
        dfsV[i] = false;
        return false;
    }
}