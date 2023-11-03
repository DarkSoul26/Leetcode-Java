class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> l=new ArrayList<String>();
        //List<Integer> al=new Stack<Integer>();
        int x=0,c=0;
        for(int i=0;i<target.length;i++){
            l.add("Push") ;
            if(target[i]!=++x){
                l.add("Pop");
                i--;
                c=1;
            }
            if(c==1 && target[i+1]>n){
                break;
            }
            else if(c==0 && target[i]>n){
                break;
            }
            c=0;
        }
        //l.add("Push");
        return l;
    }
}