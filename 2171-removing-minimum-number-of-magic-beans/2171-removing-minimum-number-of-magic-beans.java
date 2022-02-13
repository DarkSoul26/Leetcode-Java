class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long minCount = Long.MAX_VALUE;
        long c = 0;
        long b[]  = new long[beans.length];
        for(int i=beans.length-2;i>=0;i--){
            b[i] += beans[i+1]+b[i+1];
        }
        for(int i=0;i<beans.length;i++){
            long count = 0;
            count+=c;
            count+=b[i];
            count-=(long)(beans.length-i-1)*(beans[i]);
            c+=beans[i];
            if(count<minCount)
                minCount = count;
        }
        return minCount;
    }
}