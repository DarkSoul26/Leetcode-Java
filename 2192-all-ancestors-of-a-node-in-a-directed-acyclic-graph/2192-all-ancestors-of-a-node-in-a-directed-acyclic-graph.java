// class Solution {
    
//     public void dfs(List<List<Integer>> graph, int n){
        
//         for(int i=0;i<graph.get(n).size();i++){
//             for(int j=0;j<graph.get(graph.get(n).get(i)).size();j++){
//                 if(!graph.get(n).contains(graph.get(graph.get(n).get(i)).get(j)))
//                     graph.get(n).add(graph.get(graph.get(n).get(i)).get(j));
//             }   
//         }
//         List<Integer> al1 = graph.get(n);
//         Collections.sort(al1);
//         graph.set(n, al1);
//     }
//     public List<List<Integer>> getAncestors(int n, int[][] edges) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for(int i=0;i<n;i++)
//             graph.add(new ArrayList<>());
        
//         for(int i=0;i<edges.length;i++){
//             graph.get(edges[i][1]).add(edges[i][0]);
//         }
//         // boolean[] isVisited = new boolean[n];
//         for(int i=0;i<n;i++){
//             dfs(graph, i);
//         }
//         return graph;
//     }
// }

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer,Integer> dependencyCountMap = new HashMap<>();
        Map<Integer, Set<Integer>> nextNodeMap = new HashMap<>();
        Map<Integer, Set<Integer>> prevNodeMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int []edge: edges){
            dependencyCountMap.put(edge[1],dependencyCountMap.getOrDefault(edge[1],0)+1);
            Set<Integer> set = nextNodeMap.getOrDefault(edge[0],new HashSet<>());
            set.add(edge[1]);
            nextNodeMap.put(edge[0], set);
            
            set = prevNodeMap.getOrDefault(edge[1],new HashSet<>());
            set.add(edge[0]);
            prevNodeMap.put(edge[1], set);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
                if(dependencyCountMap.getOrDefault(i,0)==0){//if there are no unresolved dependencies
                    queue.offer(i);
                }
        }
        while(queue.size()>0){
            int current = queue.poll();
            for(int next: nextNodeMap.getOrDefault(current,new HashSet<>())){
                int nextCount = dependencyCountMap.getOrDefault(next,0);
                dependencyCountMap.put(next, nextCount - 1);
                if(nextCount -1 == 0)
                    queue.offer(next);
            }
            
            for(int prev: prevNodeMap.getOrDefault(current,new HashSet<>())){//pick resolved dependecies and add to result
                        map.putIfAbsent(current,new HashSet<>());
                        map.get(current).add(prev);//add 3,4 for 6
                        map.get(current).addAll(map.getOrDefault(prev, new HashSet<>()));
            }
        }
        for(int i=0;i<n;i++){
         List<Integer> list =   new ArrayList<>(map.getOrDefault(i, new HashSet<>()));
             Collections.sort(list);
        result.add(list);
        }
        
        return result;
    }
}