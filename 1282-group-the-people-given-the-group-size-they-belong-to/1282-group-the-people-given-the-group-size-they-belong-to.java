class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int size=groupSizes.length;
        List<List<Integer>> result=new ArrayList<>();
        Map<Integer,List<Integer>> groupMap=new HashMap<>();
        for(int i=0;i<size;i++) {
            groupMap.computeIfAbsent(groupSizes[i], k->new ArrayList<>()).add(i);
            if(groupMap.get(groupSizes[i]).size()==groupSizes[i]) {
                result.add(groupMap.get(groupSizes[i]));
                groupMap.put(groupSizes[i],new ArrayList<>());
            }
        }
        return result;
    }
}