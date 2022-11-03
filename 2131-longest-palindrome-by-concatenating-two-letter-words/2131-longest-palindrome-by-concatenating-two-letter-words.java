class Solution {
    public int longestPalindrome(String[] words) {
        List<Integer> al1 = new ArrayList<>();
        int count = 0;
        // boolean flag = false;
        Map<String, Integer> m = new HashMap<>();
        Map<String, Integer> m1 = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String s = words[i].substring(1,2)+words[i].substring(0,1);
            if(s.equals(words[i])){
                if(m.containsKey(words[i])){
                    m.put(words[i], m.get(words[i])+1);
                }
                else
                    m.put(words[i],1);
            }
            else{
                if(m1.containsKey(words[i])){
                    m1.put(words[i], m1.get(words[i])+1);
                }
                else
                    m1.put(words[i],1);
            }
        }
        
        for(int i=0;i<words.length;i++){
            String s = words[i].substring(1,2)+words[i].substring(0,1);
            if(!s.equals(words[i]) && (m1.containsKey(words[i]) && m1.containsKey(s))){
                if(m1.get(s)!=0 && m1.get(words[i])!=0){
                    count+=4;
                    m1.put(s,m1.get(s)-1);
                    m1.put(words[i],m1.get(words[i])-1);
                }
            }

        }
        for(Map.Entry ml: m.entrySet()){
            al1.add((int)ml.getValue());
            // System.out.println(ml.getValue());
        }
        Collections.sort(al1);
        boolean flag = false;
        for(int i=al1.size()-1;i>=0;i--){
            if(al1.get(i)%2==0 && al1.get(i)!=1){
                count+=al1.get(i)*2;
            }
            else{
                if(!flag){
                    count+=al1.get(i)*2;
                flag = true;
                }
                else{
                    
                    count+=(al1.get(i)-1)*2;
                }
            }
        }
        return count;
    }
}