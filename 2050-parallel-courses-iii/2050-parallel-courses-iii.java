class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n];
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] relation : relations) {
            indegree[relation[1] - 1]++;
            Set<Integer> set = graph.getOrDefault(relation[0] - 1, new HashSet<>());
            set.add(relation[1] - 1);
            graph.put(relation[0] - 1, set);
        }
        int totalTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] times = new int[n];
        while (!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            while (!queue.isEmpty()) {
                int course = queue.poll();
                curr.add(course);
                times[course] += time[course];
            }
            for (int course : curr) {
                Set<Integer> next = graph.getOrDefault(course, new HashSet<>());
                for (int nextCourse : next) {
                    indegree[nextCourse]--;
                    times[nextCourse] = Math.max(times[nextCourse], times[course]);
                    if (indegree[nextCourse] == 0) {
                        queue.add(nextCourse);
                    }
                }
            }
        }
        totalTime = Arrays.stream(times).max().getAsInt();
        return totalTime;
    }
}