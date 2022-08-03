class Solution {
    
    public boolean isCycle(boolean[] visited, List<List<Integer>> al, int i, int[] indegree){
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        // for(int j=0;j<indegree.length;j++){
        //     if(indegree[j] == 0)
        //         q.add(j);
        // }
        // // q.add(new Pair(i, -1 ));
        // visited[i] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            // if((int)p.getKey() == (int)p.getValue())
            //     return true;
            
            System.out.println("Key: "+p.getKey()+" Value: "+p.getValue());
            for(int j=0;j<al.get((int)p.getKey()).size();j++){
                if(visited[j] && j!=(int)p.getValue())
                    return true;
                else{
                    visited[j] = true;
                    q.add(new Pair(j, (int)p.getValue()));
                }
            }
        }
        return false;
    }
    
    public boolean isCycleDFS(boolean[] visited, boolean dfsV[], List<List<Integer>> al, int i){
        // if(visited[i] && dfsV[i])   return true;
        visited[i] = true;
        dfsV[i] = true;
        // boolean x = false;
        for(int j=0;j<al.get(i).size();j++){
            if(!visited[al.get(i).get(j)]){
                if(isCycleDFS(visited, dfsV, al, al.get(i).get(j)))
                    return true;
            }
            else if(dfsV[al.get(i).get(j)])
                return true;
        }
        dfsV[i] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            al.add(new ArrayList<>());
        // int indegree[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            if(prerequisites[i][0] == prerequisites[i][1])
                return false;
            List<Integer> al1 = al.get(prerequisites[i][0]);
            al1.add(prerequisites[i][1]);
            // if(al.get(prerequisites[i][1]).contains(prerequisites[i][0]))
            //     return false;
            // indegree[prerequisites[i][1]]++;
            // al1 = al.get(prerequisites[i][1]);
            // al1.add(prerequisites[i][0]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean dfsV[]  = new boolean[numCourses];
        // for(int i=0;i<)
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(isCycleDFS(visited, dfsV, al, i)){
                    return false;
                }
                // visited[i] = true;
                // return true;
            }
        }
        return true;
    }
}