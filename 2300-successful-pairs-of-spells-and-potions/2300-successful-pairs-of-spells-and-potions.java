class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] news = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            news[i] = spells[i];
        }
        Arrays.sort(spells);
        Arrays.sort(potions);
        Map<Integer, Integer> hm = new HashMap<>();
        int gj = potions.length-1;
        int j = 0;
        long x = 0;
        for(int i=0;i<spells.length;i++){
            
            if(hm.containsKey(spells[i]))
                continue;
            
            for(j=gj;j>=0;j--){
                x = (long)spells[i]*(long)potions[j];
                if(x<success)
                    break;
            }
            gj = j;
            hm.put(spells[i], potions.length-gj-1);
        }
        
        for(int i=0;i<spells.length;i++){
            news[i] = hm.get(news[i]);
        }
        return news;
    }
}