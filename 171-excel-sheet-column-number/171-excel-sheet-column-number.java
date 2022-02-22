class Solution {
    public int titleToNumber(String columnTitle) {
        int sum=0,j=0;
        for(int i = columnTitle.length()-1;i>=0;i--){
            sum+=Math.pow(26,j)*(columnTitle.charAt(i)-'A'+1);
            j++;
        }
        return sum;
    }
}