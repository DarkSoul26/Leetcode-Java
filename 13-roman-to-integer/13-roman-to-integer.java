class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("I",1);
        hm.put("IV",4);
        hm.put("V",5);
        hm.put("IX",9);
        hm.put("X",10);
        hm.put("XL",40);
        hm.put("L",50);
        hm.put("XC",90);
        hm.put("C",100);
        hm.put("CD",400);
        hm.put("D",500);
        hm.put("CM",900);
        hm.put("M",1000);
        int sum=0;
        for(int i=0;i<s.length()-1;i++){
            String s1 = Character.toString(s.charAt(i));
            String s2 = Character.toString(s.charAt(i+1));
            if(hm.get(s1)<hm.get(s2)){
                sum+=hm.get(s1+s2);
                i++;
            }
            else{
                sum+=hm.get(s1);
            }
        }
        if(s.length()==1)
            sum+=hm.get(Character.toString(s.charAt(0)));
        else if(hm.get(Character.toString(s.charAt(s.length()-2)))>=hm.get(Character.toString(s.charAt(s.length()-1))))
            sum+=hm.get(Character.toString(s.charAt(s.length()-1)));
        
        return sum;
    }
}