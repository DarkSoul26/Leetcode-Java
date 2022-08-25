
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> hm = new HashMap<>();
        for(int i=1;i<stones.length;i++)
            hm.put(stones[i], new HashSet<>());
        Set<Integer> al = new HashSet<>();
        al.add(1);
        hm.put(stones[0], al);
        for(int s: stones){
            // if(s == stones[0])
            //     continue;
            Set<Integer> al2 = hm.get(s);
            // if(al2.size() == 0)
            //     return false;
            // for(int i=0;i<al.size();i++){
            for(Integer i: al2){
                int x = s+i;
                if(x == stones[stones.length-1])
                    return true;
                if(hm.containsKey(x)){
                    if(i-1>0)
                        hm.get(x).add(i-1);
                    // Set<Integer> al1 = hm.get(x);
                    hm.get(x).add(i);
                    hm.get(x).add(i+1);
                }
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean jumpIt(int[] s, int i, int k, int dp[]){
//         if(i>=s.length)
//             return false;
//         if(i == s.length-1){
//             dp[i] = 1;
//             return true;
//         }
//         if(dp[i] != -1){
//             if(dp[i] == 0)
//                 return false;
//             else
//                 return true;
//         }
//         int j = i+1;
//         while(j<s.length && s[i]+k >= s[j]){
//             if(s[i]+k == s[j]){
//                 System.out.println(k);
//                 boolean x = jumpIt(s, j, k-1, dp) || jumpIt(s, j, k, dp) || jumpIt(s, j, k+1, dp);
//                 if(x){
//                     dp[i] = 1;
//                     return true;
//                 }
//                 break;
//             }
//             else if(s[i]+k > s[j])
//                 j++;
//         }
//         dp[i] = 0;
//         return false;
        
//     }
//     public boolean canCross(int[] stones) {
//         int dp[] = new int[stones.length];
//         Arrays.fill(dp, -1);
        
//         boolean x = jumpIt(stones, 0, 1, dp);
//         if(dp[stones.length-1] == 1)
//             return true;
//         return false;
//     }
// }