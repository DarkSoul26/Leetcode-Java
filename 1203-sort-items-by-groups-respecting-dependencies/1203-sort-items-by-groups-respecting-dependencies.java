class Solution {
    List<Integer>[] groups;
    List<Integer>[] graph;
    int[] indegreeItems;
    int[] indegreeGroups;
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        buildGroups(n, group);
        buildGraph(n, group, beforeItems);
        Queue<Integer> groupQueue = new LinkedList();
        for(int i =0; i <n; i++)
            if (indegreeGroups[i]==0)
                groupQueue.offer(i);
        int[] result = new int[n];
        int top = -1;
        while(!groupQueue.isEmpty()){
            int groupId = groupQueue.poll();
            List<Integer> groupItems = groups[groupId];
            if (groupItems==null)
                continue;
            Queue<Integer> itemQueue= new LinkedList();
            for(int item: groupItems)
                if (indegreeItems[item]==0)
                    itemQueue.offer(item);
            while(!itemQueue.isEmpty()){
                int u = itemQueue.poll();
                result[++top]=u;
                List<Integer> v= graph[u];
                if (v== null)
                    continue;
                for(int neighbor: v){
                    --indegreeItems[neighbor];
                    if (groupId!=group[neighbor]){
                        if (--indegreeGroups[group[neighbor]]==0)
                            groupQueue.offer(group[neighbor]);
                    }else{
                        if (indegreeItems[neighbor]==0)
                            itemQueue.offer(neighbor);
                    }
                }
            }
        }
        return (top< n-1)? new int[]{}: result;
    }
    private void buildGraph(int n, int[] group, List<List<Integer>> beforeItems){
        graph=new List[n];
        indegreeItems = new int[n];
        indegreeGroups = new int[n];
        for(int i =0; i<n; i++){
            for(int j: beforeItems.get(i)){
                if (group[i]!=group[j])
                    indegreeGroups[group[i]]++;
                if (graph[j]==null)
                    graph[j]= new ArrayList<Integer>();
                graph[j].add(i);
                indegreeItems[i]++;
            }
        }
    }

   
    private void buildGroups(int n, int[] group){
        groups = new List[n];
        int index = n-1;
        for(int i = 0; i <n; i++){
            if (group[i]==-1)
                group[i]=index--;
            if(groups[group[i]]==null)
                groups[group[i]]=new ArrayList<Integer>();
            groups[group[i]].add(i);
        }
    }
}