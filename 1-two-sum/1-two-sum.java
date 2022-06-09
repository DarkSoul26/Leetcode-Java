class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=numbers.length;
        int[] a=new int[2];
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(target==numbers[i]+numbers[j]){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }
        }
        return a;
    }
}