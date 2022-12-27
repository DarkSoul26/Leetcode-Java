class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0;i<capacity.length;i++)
            capacity[i] = capacity[i]-rocks[i];
        
        Arrays.sort(capacity);
        int count = 0;
        for(int i=0;i<capacity.length;i++){
            additionalRocks-=capacity[i];
            if(additionalRocks < 0)
                return count;
            else
                count++;
        }
        return count;
    }
}