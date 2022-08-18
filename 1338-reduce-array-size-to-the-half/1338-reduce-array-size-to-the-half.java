class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++)
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        
        List<Integer> freq = new ArrayList<>(hm.values());
        Collections.sort(freq, (a,b) -> b-a);
        int count = 0;
        int n = arr.length;
        for(int i=0;i<freq.size();i++){
            if(n>arr.length/2){
                count++;
                n-=freq.get(i);
            }
        }
        return count;
    }
}