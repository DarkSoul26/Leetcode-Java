class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i: salary){
            sum+=i;
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        sum-=min;
        sum-=max;
        return (double)sum/((double)salary.length-2);
    }
}