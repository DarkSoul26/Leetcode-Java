class Solution {
    public int minBitFlips(int start, int goal) {

        StringBuffer s1 = new StringBuffer(Integer.toString(start, 2));
        StringBuffer s2 = new StringBuffer(Integer.toString(goal, 2));
        s1.reverse();
        s2.reverse();
        int count = 0;
        for(int i=0;i<Math.min(s1.length(), s2.length());i++){
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        if(s1.length()>s2.length()){
            for(int i=s2.length();i<s1.length();i++)
                if(s1.charAt(i)=='1')
                    count++;
        }
        else if(s1.length()<s2.length()){
            for(int i=s1.length();i<s2.length();i++)
                if(s2.charAt(i)=='1')
                    count++;
        }
        
        return count;
    }
}