class Solution {
    class State {
        int keys;
        int i;
        int j;
        State( int keys, int i, int j) {
            this.keys=keys;
            this.i=i;
            this.j=j;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, n = grid.length, m = grid[0].length(), max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        int step =0;
        State start = new State(0,x,y);
        Queue<State>q=new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + x + " " + y);
        q.add(start);
        int[][] dirs=new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                State cur = q.poll();
                if(cur.keys == (1 << max) -1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = cur.i + dir[0];
                    int j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && i < n && j >= 0 && j < m) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a');
                        }
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}