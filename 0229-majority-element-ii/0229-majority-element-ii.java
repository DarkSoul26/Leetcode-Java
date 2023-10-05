class Solution {
    public List<Integer> majorityElement(int[] nums) {
         HashMap<Integer,Integer> selfMap = new HashMap<>();
        int n = nums.length/3;
        for(int i=0 ; i<nums.length ; i++){
            if(selfMap.containsKey(nums[i])){
                selfMap.put(nums[i] , selfMap.get(nums[i])+1);
            }
            else{
                selfMap.put(nums[i] , 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer , Integer> e : selfMap.entrySet()){
            if(e.getValue() > n){
                list.add(e.getKey());
            }
        }
        return list;
    }
}