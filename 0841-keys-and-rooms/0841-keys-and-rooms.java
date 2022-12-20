class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean isVisited[] = new boolean[rooms.size()];
        dfs(rooms, 0, isVisited);
        for(int i=0;i<rooms.size();i++){
            if(!isVisited[i])
                return false;
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int ind, boolean isVisited[]){
        if(isVisited[ind])
            return;
        isVisited[ind] = true;
        List<Integer> al = rooms.get(ind);
        for(int i=0;i<al.size();i++){
            dfs(rooms, al.get(i), isVisited);
        }
    }
}