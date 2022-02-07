class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(i != s.length()){
                char a = s.charAt(i);
                if(m.containsKey(a))
                    m.put(a, m.get(a)+1);
                else
                    m.put(a,1);
            }
            char b = t.charAt(i);
            if(m.containsKey(b))
                m.put(b, m.get(b)+1);
            else
                m.put(b,1);
        }
        for(Map.Entry el: m.entrySet()){
            if((int)el.getValue()%2!=0 || (int)el.getValue()==1)
                return (char)el.getKey();
        }
        return 'a';
    }
}