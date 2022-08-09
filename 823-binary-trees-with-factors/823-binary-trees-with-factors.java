class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        Map<Integer, Long> hm = new HashMap<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            long count = 1;
            // hm.put(arr[i], count);
            for(int j=0;j<i;j++){
                if((((arr[i])%mod)%(arr[j]%mod))%mod == 0){
                    int div = ((arr[i]%mod)/(arr[j]%mod))%mod;
                    if(hm.containsKey(div))
                        count = ((count)%mod + ((hm.get(arr[j]))%mod*(hm.get(div))%mod)%mod)%mod;
                }
            }
            hm.put(arr[i], count%mod);
        }
        long ans = 0;
        for(Map.Entry el: hm.entrySet()){
            // System.out.println((long)(el.getValue()));
            ans = ((ans)%mod + ((long)(el.getValue())%mod)%mod)%mod;
        }
        
        return (int)ans;
    }
}