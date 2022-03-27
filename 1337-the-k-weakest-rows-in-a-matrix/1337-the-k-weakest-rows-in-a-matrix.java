class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<mat.length;i++){
            int c = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)
                    break;
                c++;
            }
            m.put(i,c);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (a,b)->m.get(a)==m.get(b)?b-a:m.get(b)-m.get(a));
        
        for(Map.Entry el: m.entrySet()){
            maxHeap.add((int)el.getKey());
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        int a[] = new int[k];
        for(int i=k-1;i>=0;i--){
            a[i] = maxHeap.peek();
            maxHeap.poll();
        }
        // Arrays.sort(a);
        return a;
        
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.c==a.c?b.ind-a.ind:b.c-a.c);
        // for(int i=0;i<mat.length;i++){
        //     int count = 0;
        //     for(int j=0;j<mat[i].length;j++)
        //         if(mat[i][j] == 1)
        //             count++;
        //     // System.out.println(count);
        //     pq.add(new Pair(i, count));
        // }
        // int ans[] = new int[k];
        // int i = 0;
        // for(Pair p: pq){
        //     System.out.println(p.ind+" "+p.c);
        //     if(i == k)
        //         break;
        //     ans[i++] = p.ind;
        // }
        // return ans;
    }
}

class Pair{
    int ind;
    int c;
    
    Pair(int ind, int c){
        this.ind = ind;
        this.c = c;
    }
}