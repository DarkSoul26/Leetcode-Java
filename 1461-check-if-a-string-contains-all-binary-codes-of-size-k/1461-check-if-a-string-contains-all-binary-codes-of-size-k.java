class Solution {
    
    public boolean checkIt(StringBuffer sb, Map<String, Integer> hm, int k){
        if(sb.length() == k){
            
            if(!hm.containsKey(sb.toString()))
                return false;
            else
                return true;
        }
        
        if(sb.length()>k)
            return true;
        
        sb.append("0");
        boolean a = checkIt(sb, hm, k);
        sb.setLength(sb.length()-1);
        sb.append("1");
        boolean b = checkIt(sb, hm, k);
        sb.setLength(sb.length()-1);
        
        return a&b;
    }
    public boolean hasAllCodes(String s, int k) {
        // Map<String, Integer> hm = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            // hm.put(s.substring(i,i+k), hm.getOrDefault(s.substring(i,i+k)+1);
            // System.out.println(s.substring(i,i+k));
            // if(!hm.containsKey(s.substring(i,i+k)))
            //     hm.put(s.substring(i,i+k),1);
            set.add(s.substring(i,i+k));
        }
        if(set.size() == Math.pow(2, k))
            return true;
        return false;
        
        // return checkIt(new StringBuffer(), hm, k);
    }
}