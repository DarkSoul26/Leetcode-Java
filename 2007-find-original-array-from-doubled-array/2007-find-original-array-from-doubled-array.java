class Solution {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> hm = new TreeMap<>();
        for(int i=0;i<changed.length;i++)
            hm.put(changed[i], hm.getOrDefault(changed[i], 0)+1);
        
        int []ans = new int[changed.length/2];
        int i = 0;
        if(changed.length%2==1)
            return new int[0];
        for(Map.Entry el: hm.entrySet()){
            int k = (int)el.getKey();
            if((int)el.getValue() > hm.getOrDefault(k+k, 0))
                return new int[0];
            // if((int)el.getValue() == 0)
            //     continue;
            // while(hm.getOrDefault(k+k, 0)!=0){
            for (int j = 0; j < hm.get(k); ++j) {
                ans[i++] = k;
                hm.put(k+k, hm.get(k+k)-1);
                // hm.put(k, hm.get(k)-1);
            }   
            // if((int)el.getValue() != 0)
            //     return new int[0];
        }
        return ans;
    }
}