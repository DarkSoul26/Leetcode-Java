class Solution {
    List<List<Integer>> al=new ArrayList<>(); 
    int j=0;
    
    public List<List<Integer>> generate(int numR) {
        if(j==0){
            List<Integer> al3=new ArrayList<>();
            al3.add(1);
            al.add(al3);
        }
         if(numR==1)
             return al;
        List<Integer> al1=new ArrayList<>();
        al1.add(1);
        
        List<Integer> temp = al.get(j);
        for(int i=0;i<temp.size()-1;i++){
            al1.add(temp.get(i)+temp.get(i+1));
        }
        al1.add(1);
        al.add(al1);
        j++;
        return generate(--numR);
    }
}