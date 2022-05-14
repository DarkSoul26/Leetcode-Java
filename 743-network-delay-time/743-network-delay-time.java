class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new Node(time[1], time[2]));
        }
        int[] arr= new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k, 0});
        arr[k] = 0;
        while(!q.isEmpty()){
            int curr[] = q.poll(), src = curr[0], t = curr[1];
            for(Node child : map.getOrDefault(src, new ArrayList<>())){
                if(arr[child.dest] > curr[1] + child.time){
                    arr[child.dest] = curr[1] + child.time;
                    q.add(new int[]{child.dest, curr[1]+child.time});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(arr[i],max);
        }
        return max;
    }
    class Node{
        int dest, time;
        Node(int dest, int time){
            this.dest = dest;
            this.time = time;
        }
    }
}