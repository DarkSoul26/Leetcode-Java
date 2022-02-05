class Solution {
        public int findMaxLength(int[] nums) {
            int trigger = 0;
            HashMap<Integer,Integer> hm = new HashMap<>();
            hm.put(0,-1);
            int maxLength = 0;
            for(int i=0;i<nums.length;i++){
                int num = nums[i];
                if(num == 0)trigger--;
                else trigger++;

                if(!hm.containsKey(trigger)){
                    hm.put(trigger,i);
                }
                maxLength = Math.max(maxLength,-hm.get(trigger)+i);
            }

            return maxLength;
        }
}