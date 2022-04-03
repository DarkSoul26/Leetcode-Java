class Solution {
    public int convertTime(String current, String correct) {
        int currSec = Integer.parseInt(current.substring(0,2))*60+Integer.parseInt(current.substring(3,5));
        int secReq = Integer.parseInt(correct.substring(0,2))*60+Integer.parseInt(correct.substring(3,5));
        int count = 0;
        secReq = secReq-currSec;
        if(secReq>=60){
            count+=secReq/60;
            secReq = (secReq)%60;
        }
        if(secReq>=15){
            count+=(secReq)/15;
            secReq = (secReq)%15;
        }
        if(secReq>=5){
            count+=(secReq)/5;
            secReq = (secReq)%5;
        }
        if(secReq>=1){
            count+=secReq;
            secReq = (secReq);
        }
        
        return count;
    }
}