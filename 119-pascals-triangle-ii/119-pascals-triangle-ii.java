class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++)
            al.add(1);
        for(int i=0;i<rowIndex-1;i++){
            for(int j=i+1;j>=1;j--){
                al.set(j, al.get(j)+al.get(j-1));
            }
        }
        return al;
    }
}