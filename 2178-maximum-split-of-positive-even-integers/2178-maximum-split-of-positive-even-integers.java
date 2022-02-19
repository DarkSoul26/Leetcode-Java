class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum%2!=0)
            return new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        for(long i=2;i<=finalSum;i+=2){
            ans.add(i);
            finalSum-=i;
        }
        if(finalSum == 0)
                return ans;
        else{
            long x = ans.remove(ans.size()-1);
            ans.add(x+finalSum);
        }
        return ans;
    }
}