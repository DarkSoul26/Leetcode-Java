class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minD = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++)
            minD = Math.min(minD, arr[i+1]-arr[i]);
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i] == minD){
                List<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                al.add(arr[i+1]);
                ans.add(al);
            }
        }
        return ans;
    }
}