class Solution {
    Set<List<Integer>> al;
    public void combi(int[] a, int t, int sum, List<Integer> al1, int i){
        if(sum == t){
            // List<Integer> al2 = new ArrayList<>(al1);
            // Collections.sort(al2);
            al.add(new ArrayList<>(al1));
            return;
        }
        if(i>=a.length)
            return;
        // if(sum>t)
        //     return;
        for(int j=i;j<a.length;j++){
            if(j>i && a[j]==a[j-1]) continue;
            if(a[j]+sum<=t){
                al1.add(a[j]);
                // if(!al.contains(al1)){
                combi(a, t, sum+a[j], al1, j+1);
                // }
                al1.remove(al1.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        al = new HashSet<>();
        // boolean[] a = new boolean[candidates.length];
        Arrays.sort(candidates);
        combi(candidates, target, 0, new ArrayList<>(), 0);
        // List<List<Integer>> alFinal = new ArrayList<>();
        // for(List<Integer> l: al){
        //     alFinal.add(l);
        // }
        return new ArrayList<>(al);
    }
}