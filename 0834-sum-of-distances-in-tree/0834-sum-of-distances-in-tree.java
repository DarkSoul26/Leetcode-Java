class Solution {
     public int[] sumOfDistancesInTree(int n, int[][] edges) {

        final ArrayList<Integer>[] graph = new ArrayList[n];
        final int[] count = new int[n];
        Arrays.fill(count, 1);
        final int[] answer = new int[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        postOrder(0, -1, graph, count, answer);

        preOrder(0, -1, graph, count, answer, n);

        return answer;
    }

    private void postOrder(int node, int parent, ArrayList<Integer>[] graph, int[] count, int[] answer) {
        for (int child : graph[node]) {
            if (child != parent) {
                postOrder(child, node, graph, count, answer);
                count[node] += count[child];
                answer[node] += answer[child] + count[child];
            }
        }
    }

    private void preOrder(int node, int parent, ArrayList<Integer>[] graph, int[] count, int[] answer, int n) {
        for (int child : graph[node]) {
            if (child != parent) {
                answer[child] = answer[node] + (n - count[child]) - count[child];
                preOrder(child, node, graph, count, answer, n);
            }
        }
    }
}