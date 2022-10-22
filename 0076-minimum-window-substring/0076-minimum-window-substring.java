class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        int len1 = s.length();
        int len2 = t.length();
        for(int i=0;i<len2;i++){
            char a = t.charAt(i);
            if(!m1.containsKey(a))
                m1.put(a,1);
            else
                m1.put(a,m1.get(a)+1);
        }
        int count = m1.size(),i=0,j=0;
        String temp = "";
        int max = Integer.MAX_VALUE;
        while(j<len1 && i<=j){
            char t1 = s.charAt(j);
            if(m1.containsKey(t1)){
                m1.put(t1,m1.get(t1)-1);
                if(m1.get(t1)==0)
                    count--;
            }
            while(count==0){
                char a = s.charAt(i);
                if(m1.containsKey(a)){
                    m1.put(a,m1.get(a)+1);
                    if(m1.get(a)==1)
                        count++;
                    if(max>j-i+1){
                        max = j-i+1;
                        temp = s.substring(i,j+1);
                    }
                }
                
                i++;
            }
            j++;
        }
        return temp;
//             if(count!=len2){
//                 char temp = s.charAt(j);
//                 if(m1.containsKey(temp)){
//                     if(m2.containsKey(temp)){
//                         if(m2.get(temp)==m1.get(temp)){
//                             count++;
//                         }
//                         else{
//                             m2.put(temp,m2.get(temp)+1);
//                         }
//                     }
//                     else{
//                         m2.put(temp,1);
//                         count++;
//                     }
//                 }
//                 j++;
                
//             }
//             if(count==len2){
//                 char temp = s.charAt(i);
//                 if(m2.containsKey(temp)){
//                     m2.put(temp,m2.get(temp)-1);
//                     count--;
//                 }
//                 // if(m2.get(temp)<m1.get(temp))
//                 //     count--;
//                 i++;
//             }
        
        
        
//         int i=0,j=0;
//         int len1 = s.length(), len2 = t.length();
//         Map<Character, Integer> m1 = new HashMap<>();
//         Map<Character, Integer> m2 = new HashMap<>();
//         for(int i=0;i<len2;i++){
//             char temp = t.charAt(i);
//             if(m1.containsKey(temp))
//                 m1.put(temp,m1.get(temp)+1);
//             else
//                 m1.put(temp,1);
//         }
//         while(j<len1){
//             char temp = s.charAt(j);
//             if(m1.conatainsKey(temp) && m2.containsKey(temp))
//                 m2.put(temp,m2.get(temp)+1);
//             else
//                 m2.put(temp,1);
            
//         }
    }
}