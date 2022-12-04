class Solution {
    public String frequencySort(String s) {
        int a[] = new int[128];
        for(int i=0;i<s.length();i++){
            int x = (int)(s.charAt(i));
            a[x]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((c,b)->b[0]-c[0]);
        for(int i=0;i<128;i++){
            if(a[i]!=0){
                int entry[] = {a[i],i};
                pq.add(entry);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            int x[] = pq.poll();
            char ch = (char)(x[1]);
            while(x[0]>0){
                sb.append(ch);
            x[0]--;
            }
        }
        return sb.toString();
    }
}