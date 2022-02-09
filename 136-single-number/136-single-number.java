class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int num: nums)
            m.put(num, m.getOrDefault(num,0)+1);
        
        for(Map.Entry el: m.entrySet()){
            if((int)el.getValue()==1)
                return (int)el.getKey();
        }
        return -1;
    }
}