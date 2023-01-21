class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res= new LinkedList<>();
        helper(res,"",s,0);
        return res;
    }
    
    public void helper(List<String> res, String path, String s, int k) {
        
        if(s.length() == 0 || k == 4) {
            if(s.length() ==0 && k == 4) 
                res.add(path.substring(1));
            return;
        }
        
        for(int i=1;i<= (s.charAt(0) =='0'? 1:3) && i<=s.length() ;i++) {
            String part = s.substring(0,i);
            if(Integer.valueOf(part)<=255)
                helper(res, path + "." + part, s.substring(i), k+1);
        }
    }
}