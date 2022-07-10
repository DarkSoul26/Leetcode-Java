class Solution {
    public int fillCups(int[] amount) {
        int count = 0;
        while(true){
            if(amount[0]==0 && amount[1]==0 && amount[2]==0)
                break;
            Arrays.sort(amount);
            if(amount[2]!=0 && amount[1]!=0){
                amount[2]--;
                amount[1]--;    
                count++;
            }
            else if(amount[2]!=0){
                count+=amount[2];
                break;
            }
        }
        return count;
    }
}