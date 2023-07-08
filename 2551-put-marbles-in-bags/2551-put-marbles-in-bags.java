class Solution {
    public long putMarbles(int[] weights, int k) {
        long max = 0;
        long min = 0;
        List<Integer> list = new ArrayList();
        for(int i=1; i<weights.length; i++){
            list.add(weights[i]+weights[i-1]);
        }
        Collections.sort(list);

        for(int i=0; i<k-1; i++){
            min+=list.get(i);
            max+=list.get(list.size()-1-i);
        }
        return max-min;
    }
}