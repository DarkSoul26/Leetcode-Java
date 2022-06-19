class Trie{
    Trie a[];
    boolean flag;

    Trie(){
        a = new Trie[26];
        flag = false;
    }
    
    void put(char x){
        if(a[x-'a'] == null)
            a[x-'a'] = new Trie();
    }
     
    boolean contains(char x){
        if(a[x-'a'] == null) return true;
        return false;
    }
    
    Trie get(char x){
        return a[x-'a'];
    }
    
    void endIt(){
        flag = true;
    }
    
    // List<
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> ans = new ArrayList<>();
        TreeMap<String, Integer> ts = new TreeMap<>();
        List<String> convert = Arrays.asList(products);
        Arrays.sort(products);
        for(int i=0;i<products.length;i++)
            ts.put(products[i], i);
        String key = "";
        for(char c: searchWord.toCharArray()){
            key+=c;
            String from = ts.ceilingKey(key);
            String to = ts.floorKey(key+"{");
            
            if(from == null || to == null)  break;
            
            ans.add(convert.subList(ts.get(from), Math.min(ts.get(from)+3, ts.get(to)+1)));
        }
        
        while(ans.size()<searchWord.length()) ans.add(new ArrayList<>());
        return ans;
//         Trie root = new Trie();
//         Trie x = root;
//         for(int i=0;i<products.length;i++){
//             for(int j=0;j<products[i].length();j++){
//                 if(!x.contains(products[i].charAt(j)))
//                     x.put(products[i].charAt(j));
//                 x = x.get(products[i].charAt(j));
//             }
//             x.endIt();
//         }
        
//         List<List<String>> sl = new ArrayList<>();
//         Trie rootNew = root;
//         String add = "";
//         for(int i=0;i<searchWord.length();i++){
//             if(rootNew.contains(searchWord.charAt(i))){
//                 add+=searchWord.charAt(i);
//                 rootNew = rootNew.getAll(searchWord.charAt(i));
//             }
                
//         }
    }
}