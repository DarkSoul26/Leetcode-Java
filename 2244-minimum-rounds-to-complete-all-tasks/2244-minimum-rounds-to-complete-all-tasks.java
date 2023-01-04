class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<tasks.length;i++)
            m.put(tasks[i], m.getOrDefault(tasks[i], 0)+1);
        int count = 0;
        // for(Map.Entry el: m.entrySet()){
        //     // int key = (int)el.getKey();
        //     int val = (int)el.getValue();
        //     System.out.print(val+" ");
        // }
        for(Map.Entry el: m.entrySet()){
            int key = (int)el.getKey();
            int val = (int)el.getValue();
            if((val%3)%2==0 && val%3!=0){
                count+=val/3;
                val = val%3;
            }
            if((val%2)%3==0 && val%2!=0){
                count+=val/2;
                val = val%2;
            }
            // if(val%3)==0){
            //     count+=val/3;
            //     val = val%3;
            // }
            // if(val%2==0){
            //     count+=val/2;
            //     val = val%2;
            // }
            if((val%3+3)%2==0){
                if(val>=3){
                    count+=val/3-1;
                    val = val%3+3;
                }
            }
            if(val%3==0){
                count+=val/3;
                val = val%3;
            }
            if((val%2+2)%3==0){
                if(val>=2){
                    count+=val/2-1;
                    val = val%2+2;
                }
            }
            if(val%3==0){
                count+=val/3;
                val = val%3;
            }
            if(val%2==0){
                count+=val/2;
                val = val%2;
            }
            // System.out.print(count+" ");
            if(val!=0)
                return -1;
        }
        return count;
    }
}