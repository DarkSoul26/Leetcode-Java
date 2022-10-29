class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Pair<Integer, Integer>> plant = new ArrayList<>();
        for(int i=0;i<plantTime.length;i++)
            plant.add(new Pair(plantTime[i], growTime[i]));
        
        Collections.sort(plant, new Comparator<Pair<Integer, Integer>>(){
             public int compare(Pair<Integer, Integer> p1, 
                                Pair<Integer, Integer> p2){
                 return p2.getValue()-p1.getValue();
             }
        });
        
        int start = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<plantTime.length;i++){
            start+=plant.get(i).getKey();
            max = Math.max(max, start+plant.get(i).getValue());
        }
        return max;
    }
}