class pair{
    String x;
    int y;
    pair(String x1,int y1){
        x=x1;
        y=y1;
    }
}

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n=queries.length;
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->(b.x.compareTo(a.x))==0?b.y-a.y:b.x.compareTo(a.x));
        int ans[]=new int[n];
        int r1=0;
        for(int p[]:queries){
            int k=p[0];
            int trim=p[1];
            int y1=0;
            for(String x:nums){
                int u=x.length();
                x=x.substring(u-trim);
                q.add(new pair(x,y1));
                if(q.size()>k){
                    q.poll();
                }
                y1++;
            }
            ans[r1++]=q.poll().y;
            q.clear();
        }
        return ans;
    }
}