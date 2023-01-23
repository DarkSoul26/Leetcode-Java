class Solution {
    public boolean binarySearch(int[][] t, int l, int r, int target){
        if(l>r)
            return false;
        int mid = l+(r-l)/2;
        if(t[mid][0]==target)
            return true;
        else if(t[mid][0]>target)
            return binarySearch(t, l, mid-1, target);
        return binarySearch(t, mid+1, r, target);
        
    }
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1)
            return 1;
        Map<Integer, Integer> map1 = new HashMap<>();
        java.util.Arrays.sort(trust, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for(int i=0;i<trust.length;i++){
            if(map1.containsKey(trust[i][1])){
                map1.put(trust[i][1], map1.get(trust[i][1])+1);
            }
            else{
                map1.put(trust[i][1], 1);
            }
        }
        for(Map.Entry m: map1.entrySet()){
            if((int)m.getValue()==n-1){
                if(!binarySearch(trust,0,trust.length-1,(int)m.getKey()))
                    return (int)m.getKey();
                
            }
        }
        return -1;
            
    }
}