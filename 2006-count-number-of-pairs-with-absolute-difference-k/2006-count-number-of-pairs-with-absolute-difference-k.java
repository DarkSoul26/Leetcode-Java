class Solution {
    public int countKDifference(int[] numbers, int target) {
        int l=numbers.length;
        int count = 0;
        // int[] a=new int[2];
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(target==Math.abs(numbers[i]-numbers[j])){
                    count++;
                    // return a;
                }
            }
        }
        return count;
    }
}