class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++){
            temp[i][0] = intervals[i][0];
            temp[i][1] = intervals[i][1];
        }
        
        temp[intervals.length][0] = newInterval[0];
        temp[intervals.length][1] = newInterval[1];
        
        Arrays.sort(temp, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0] == b[0]?a[1]-b[1]:a[0]-b[0];
            }
        });
        
        int p[] = new int[2];
        p[0] = temp[0][0];
        p[1] = temp[0][1];
        List<List<Integer>> al = new ArrayList<>();
        for(int i=1;i<temp.length;i++){
            if(temp[i][0]<=p[1]){
                p[1] = Math.max(p[1], temp[i][1]);
            }
            else{
                List<Integer> a1 = new ArrayList<>();
                a1.add(p[0]);
                a1.add(p[1]);
                al.add(a1);
                
                p[0] = temp[i][0];
                p[1] = temp[i][1];
            }
        }
        List<Integer> a1 = new ArrayList<>();
        a1.add(p[0]);
        a1.add(p[1]);
        al.add(a1);

        int[][] ans = new int[al.size()][2];
        for(int i=0;i<al.size();i++){
            ans[i][0] = al.get(i).get(0);
            ans[i][1] = al.get(i).get(1);
        }
        
        return ans;
    }
}