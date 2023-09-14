class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        //Time: O(T);
        for (List<String> ticket: tickets) {
            graph.computeIfAbsent(ticket.get(0), k-> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> path = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty() ){
            String source = stack.peek();
            if (graph.containsKey(source) && !graph.get(source).isEmpty())
                stack.push(graph.get(source).poll());
            else
                path.add(0, stack.pop());
        }
        return path;
    }
}