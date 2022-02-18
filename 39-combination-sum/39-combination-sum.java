class Solution {
    Set<List<Integer>> al;
    public void combi(int[] a, int t, int sum, List<Integer> al1){
        if(sum == t){
            List<Integer> al2 = new ArrayList<>(al1);
            Collections.sort(al2);
            // if(!al.contains(al2))
                al.add(al2);
            return;
        }
        if(sum>t)
            return;
        for(int j=0;j<a.length;j++){
            if(a[j]+sum<=t){
                al1.add(a[j]);
                // if(!al.contains(al1)){
                    combi(a, t, sum+a[j], al1);
                // }
                al1.remove(al1.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        al = new HashSet<>();
        combi(candidates, target, 0, new ArrayList<>());
        List<List<Integer>> alFinal = new ArrayList<>();
        for(List<Integer> l: al){
            alFinal.add(l);
        }
        return alFinal;
    }
}