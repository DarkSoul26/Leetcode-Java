class Solution {
    class couple {
        int first;
        double second;
        couple(int first, double second) {
            this.first=first;
            this.second=second;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<couple>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(i, new ArrayList<>());
        for(int i=0;i<edges.length;i++) {
            int[] edge=edges[i];
            
            adj.get(edge[0]).add(new couple (edge[1], succProb[i]));
            adj.get(edge[1]).add(new couple (edge[0], succProb[i]));
        }
        double[] res = new double[n];
        PriorityQueue<couple>pq=new PriorityQueue<>( (a,b)->(((Double)b.second).compareTo((Double)a.second)));
        pq.add(new couple(start, 1.0));
        
        while(!pq.isEmpty()) {
            
            couple temp = pq.poll();
            int parent=temp.first;
            double probs=temp.second;
            if(parent==end)
                return probs;
            
            for(couple li : adj.get(parent)) {
                
                int child=li.first;
                double child_prob=li.second;
                if(res[child] >= probs*child_prob)
                    continue;
                res[child] = probs*child_prob;
                pq.add(new couple (child, probs*child_prob));
            }
        }
        return 0;
    }
}