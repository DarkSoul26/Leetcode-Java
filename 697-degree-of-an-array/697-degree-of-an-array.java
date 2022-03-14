class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Pair> m = new HashMap<>();
        int maxDeg = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                Pair a = m.get(nums[i]);
                a.deg = a.deg+1;
                maxDeg = Math.max(maxDeg, a.deg);
                a.y = i;
                m.put(nums[i], a);
            }
            else{
                Pair a = new Pair(1, i, -1);
                maxDeg = Math.max(maxDeg, a.deg); 
                m.put(nums[i], a);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(Map.Entry el: m.entrySet()){
            Pair t = (Pair)el.getValue();
            if(t.y != -1 && t.y-t.x+1<ans && maxDeg == t.deg)
                ans = t.y-t.x+1;
        }
        if(ans ==Integer.MAX_VALUE)
            return 1;
            
        return ans;
    }
}

class Pair{
    int deg;
    int x;
    int y;
    Pair(int deg, int x, int y){
        this.deg = deg;
        this.x = x;
        this.y = y;
    }
}