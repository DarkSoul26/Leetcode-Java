class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.isEmpty()) {
            return null;
        }
        
        int rows = nums.size();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        List<Integer> resultList = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                resultList.add(nums.get(current[0]).get(current[1]));
                
                if (current[1] == 0 && current[0] < rows - 1) {
                    queue.offer(new int[] {current[0] + 1, current[1]});
                }
                if (current[1] < nums.get(current[0]).size() - 1) {
                    queue.offer(new int[] {current[0], current[1] + 1});
                }
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}