class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths){
            String[] segments = path.split(" ");
            for(int i = 1; i < segments.length; i++){
                String f = segments[i];
                String content = f.substring(f.indexOf('('), f.indexOf(')') );

                List<String> list = map.getOrDefault(content, new ArrayList<>());
                map.put(content, list);
                list.add(segments[0] +'/'+ f.substring(0, f.indexOf('(')));
            }
        }
        for(String key : map.keySet()){
            if (map.get(key).size() <= 1) continue;
            res.add(map.get(key));
        }
        return res;
    }
}