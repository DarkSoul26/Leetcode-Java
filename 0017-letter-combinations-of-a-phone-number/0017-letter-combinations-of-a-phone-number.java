class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<String>();

        for(int i=0;i<digits.length();i++){
            if(digits.charAt(i)-'2' < 0 || digits.charAt(i)-'9' > 0  )  {return res;    }
            else    {continue;}            
        }

        char[][] ref = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        res.add("");
        
        for(int i=0;i<digits.length();i++){
            
        	int index;
            if(digits.charAt(i)-'2' >= 0 && digits.charAt(i)-'9' <= 0  ){
                 index = (int) digits.charAt(i)-'2';
            }else   {continue;}
     
            int len = res.size();
            for(int j=0;j<len;j++){
                
                String str = res.remove(0);
                for(char ch: ref[index]){
                    res.add(str+ch);
                }
                
            }
        }
        
        if(res.size() == 1){
        	res.remove(0);
        }
        return res;
       
    }
}