class Solution {
    public int minSwaps(String s) {
        int countClose = 0, maxClose = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '[')
                countClose--;
            else{
                countClose++;
                maxClose = Math.max(maxClose, countClose);
            }
        }
        return (maxClose+1)/2;
    }
}