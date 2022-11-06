class Solution {
    public String orderlyQueue(String s, int k) {
        String ans = s;
        if(k == 0)
            return s;
        else if(k>1){
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String str = String.copyValueOf(a);
            return str;
        }
        else{
            // String temp = s;
            String temp1 = s;
            for(int i=0;i<s.length();i++){
                temp1 = temp1.substring(1,s.length())+temp1.substring(0,1);
                if(ans.compareTo(temp1)>0)
                    ans = temp1;
                // temp = temp1;
            }
        }
        return ans;
    }
}