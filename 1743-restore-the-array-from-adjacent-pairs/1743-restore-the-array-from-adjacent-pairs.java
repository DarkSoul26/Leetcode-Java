class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] res=  new int[adjacentPairs.length + 1];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int[] pairs : adjacentPairs){
            List<Integer> list = graph.getOrDefault(pairs[0],new ArrayList<>());
            list.add(pairs[1]);
            graph.put(pairs[0],list);
            
            list = graph.getOrDefault(pairs[1],new ArrayList<>());
            list.add(pairs[0]);
            graph.put(pairs[1],list);
        }
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        
        for(Map.Entry<Integer,List<Integer>> entry: graph.entrySet()){
            if( entry.getValue().size() == 1 ){
                stack.push(entry.getKey());
                break;
            }
        }
        
        int i = 0;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            res[i++] = curr;
            seen.add(curr);
            for(int neighbours : graph.get(curr)){
                if(!seen.contains(neighbours)){
                    stack.push(neighbours);
                }
            }
        }
        
        return res;
    }
}