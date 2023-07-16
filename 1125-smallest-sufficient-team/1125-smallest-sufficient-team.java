class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i)
            map.put(req_skills[i], i);
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        
        int[] skillPerson = new int[m];
        for (int i = 0; i < m; i ++) {
            List<String> list = people.get(i);
            int val = 0;
            for (String skill : list) {
                val |= 1 << map.get(skill);
            }
            skillPerson[i] = val;
        }
        boolean[] banned = new boolean[m];
        for (int i = 0; i < m; i ++) {
            for (int j = i + 1; j < m; j ++) {
                int val = skillPerson[i] | skillPerson[j];
                if (val == skillPerson[i]) {
                    banned[j] = true;
                } else if (val == skillPerson[j]) {
                    banned[i] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(banned[i]) continue;
            int cur_skill = skillPerson[i];
            
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] == null) continue;
                int comb = j | cur_skill;
                if (dp[comb] == null || dp[j].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[j]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }
}