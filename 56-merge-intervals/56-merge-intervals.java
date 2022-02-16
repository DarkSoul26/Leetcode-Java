class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });
        List<List<Integer>> al = new ArrayList<>();
        int ptr[] = new int[2];
        ptr[0] = intervals[0][0];
        ptr[1] = intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=ptr[1]){
                ptr[1] = Math.max(ptr[1], intervals[i][1]);
            }
            else{
                List<Integer> al1 = new ArrayList<>();
                al1.add(ptr[0]);
                al1.add(ptr[1]);
                al.add(al1);
                ptr[0] = intervals[i][0];
                ptr[1] = intervals[i][1];
            }
        }
        List<Integer> al1 = new ArrayList<>();
        al1.add(ptr[0]);
        al1.add(ptr[1]);
        al.add(al1);
        int a[][] = new int[al.size()][2];
        for(int i=0;i<al.size();i++){
            a[i][0] = al.get(i).get(0);
            a[i][1] = al.get(i).get(1);
        }
        return a;
    }
}