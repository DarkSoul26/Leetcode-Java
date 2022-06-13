class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int x = 0;
        for(int i=0;i<brackets.length;i++){
            if(income>brackets[i][0]-x){
                ans+=(double)(brackets[i][0]-x)*(double)brackets[i][1]/(double)100;
                income -= brackets[i][0]-x;
            }
            else{
                if(income<=0)
                    return ans;
                ans+=(double)(Math.abs(income))*(double)brackets[i][1]/(double)100;
                return ans;
            }

            x = brackets[i][0];
        }
        return ans;
    }
}