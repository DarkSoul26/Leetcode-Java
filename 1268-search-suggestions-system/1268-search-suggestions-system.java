class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        String c = ""; 
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++){
            List<String> sublist = new ArrayList<>();
            c += searchWord.charAt(i); 
            for(int j = 0; j < products.length; j++){
                if(products[j].length() >= c.length() && c.compareTo(products[j].substring(0, c.length())) == 0){
                    sublist.add(products[j]);
                    if(sublist.size() == 3){
                        break;
                    }
                }
            }
            list.add(sublist);
        }
        return list; 
    }
}
