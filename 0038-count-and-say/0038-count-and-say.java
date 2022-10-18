class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String s = countAndSay(n-1);
        int look = -1, count = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                sb.append(count);
                sb.append(s.charAt(i-1));
                count = 1;
            }
            else{
                count++;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length()-1));
        
        return sb.toString();
    }
}