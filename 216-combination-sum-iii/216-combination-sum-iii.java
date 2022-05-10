class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> masterList = new ArrayList<>();
        recur(masterList,new ArrayList<>(), 1, n,k);
        return masterList;
    }
  
  public  void recur( List<List<Integer>> masterList ,List<Integer> temp, int index, int n , int k){
        if(temp.size() == k){
            if(n == 0){
                masterList.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            if(n-i<0){
              continue;
            }
            temp.add(i);
            recur( masterList,temp , i+1 , n-i , k);
            temp.remove(temp.size()-1);
        }
    }
}