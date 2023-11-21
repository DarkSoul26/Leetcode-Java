class Solution {
    public int rev(int n){
        int num=0;
        while(n!=0){
            int digit=n%10;
            num=num*10+digit;
            n=n/10;
        }
        return num;
    }
    public int countNicePairs(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]-rev(nums[i]);
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                count=(count+map.get(nums[i]))%1000000007;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

       
        return count;
    }
}