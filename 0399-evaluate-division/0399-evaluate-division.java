// import java.util.Pair ;
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String divider = equation.get(0);
            String divisor = equation.get(1);
            if (!graph.containsKey(divider)) graph.put(divider, new HashMap<>());
            graph.get(divider).put(divisor, value);
            if (!graph.containsKey(divisor)) graph.put(divisor, new HashMap<>());
            graph.get(divisor).put(divider, 1 / value);
        }
        
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String divider = query.get(0);
            String divisor = query.get(1);
            if (!graph.containsKey(divider) || !graph.containsKey(divisor)) continue;
            if (divider.equals(divisor)) {
                res[i] = 1.0;
                continue;
            }
            Queue<Pair<String, Double>> q = new LinkedList<>();
            q.add(new Pair(divider, 1.0));
            Map<String, Boolean> visited = new HashMap<>();
            while (!q.isEmpty()) {
                Pair<String, Double> pair = q.poll();
                String s = pair.getKey();
                double value = pair.getValue();
                visited.put(s, true);
                for (String key : graph.get(s).keySet()) {
                    if (!visited.containsKey(key)) {
                        if (key.equals(divisor)) {
                            res[i] = graph.get(s).get(key) * value;
                            break;
                        }
                        q.offer(new Pair(key, value * graph.get(s).get(key)));
                        visited.put(key, true);
                    }
                }
            }
        }
        return res;
    }
}