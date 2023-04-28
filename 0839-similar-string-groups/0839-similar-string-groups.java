class Solution {
    public int numSimilarGroups(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        int res=0;
        
        for(int i=0; i<strs.length; i++){
            if(!visited[i]){
                res++;
                dfs(strs, visited, i);
            }
        }
        return res;
    }
    
    private void dfs(String[] strs, boolean[] visited, int index){  
        visited[index] = true; 
        String curr = strs[index];
        
        for(int i=0; i<strs.length; i++){     
            if(!visited[i] && isSimilar(curr, strs[i])){
                dfs(strs, visited, i);
            }      
        }
    }
    
    
    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) 
                diff++;
        }
        
        return (diff == 2 || diff == 0);
    }
}