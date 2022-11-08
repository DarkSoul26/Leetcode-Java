class Solution {
    public String makeGood(String s) {
        if(s.length() == 1)
            return s;
        StringBuilder sb = new StringBuilder(s);
        int j = 1;
        if(Math.abs(s.charAt(0)-s.charAt(1)) == 32){
            sb.delete(0,1);
            sb.delete(0,1);
        }
        boolean flag = true;
        while(flag){
            boolean f1 = false;
            for(int i=j;i<sb.length();i++){
                if(Math.abs(sb.charAt(i-1)-sb.charAt(i)) == 32){
                    sb.delete(i-1, i);
                    sb.delete(i-1, i);
                    f1 = true;
                }
            }
            flag = f1;
        }
        return sb.toString();
    }
}