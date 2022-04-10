class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
            pq.add((long)nums[i]);
        long x = -1;
        while(k--!=0){
            x = pq.remove();
            pq.add(x+1);
        }
        // while(k>0){
        //     long num1=pq.remove();
        //     long num2=pq.remove();
        //     long diff=Math.min(k,(num2-num1)+1);
        //     num1+=diff;
        //     k-=diff;
        //     pq.add(num1);
        //     pq.add(num2);
        // }
        // Arrays.sort(nums);
        // int i = 0;
        // // for(int j=0;j<nums.length;j++){
        // //     System.out.print(nums[i]+" ");
        // // }
        // // System.out.println();
        // while(k>0){
        //     while(i<nums.length-1 && nums[i]==nums[i+1]){
        //         i++;
        //     }
        //     if(i == nums.length-1){
        //         // if(nums[0] == nums[nums.length-1]){
        //         // if(nums[i-1] == nums[i]){
        //         //     i = 0;
        //         //     continue;
        //         // }
        //             nums[i]++;
        //             k--;
        //         // }
        //         // else{
        //             i = 0;
        //             continue;
        //         // }
        //     }
        //     else if(k>nums[i+1]-nums[i]){
        //         k-=nums[i+1]-nums[i];
        //         nums[i] = nums[i+1];
        //         i++;
        //     }
        //     else{
        //         nums[i]+=k;
        //         k = 0;
        //         i++;
        //     }
        // }
        long ans = 1;
        long m = 1000000007;
        // for(int j=0;j<nums.length;j++){
        //     System.out.print(nums[j]+" ");
        //     ans=(ans%m*nums[j]%m)%m;
        // }
        // Iterator v = pq.iterator();
        while(!pq.isEmpty()){
            x = pq.remove();
            ans=(ans%m*x%m)%m;
        }
        return (int)ans;
    }
}