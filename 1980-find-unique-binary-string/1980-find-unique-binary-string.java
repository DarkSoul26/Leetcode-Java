class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>(List.of(nums));
        Deque<String> q = new ArrayDeque<>();
        q.add("0");
        q.add("1");
        int level = 1;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                String top = q.pollFirst();
                if (level == n && !set.contains(top)) return top;
                q.add(top + "0");
                q.add(top + "1"); 
            }
            level++;
        }
        return "";
    }
}