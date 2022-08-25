class Node{
    // Node next;
    Node link[] = new Node[2];
    // Node(int i){
    //     if(i == 0)
    //         link[0].next = new Node();
    //     else
    //         link[1].next = new Node();
    // }
    
    boolean contains(int k){
        if(link[k]!=null)
            return true;
        return false;
    }
    
    Node get(int k){
        return link[k];
    }
    
    void put(int k, Node node){
        link[k] = node;
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    
    void insert(int n){
        Node temp = root;
        for(int i=31;i>=0;i--){
            int b = (n>>i)&1;
            if(!temp.contains(b)){
                temp.put(b, new Node());
            }
            temp = temp.get(b);
        }
    }
    
    int getMax(int n){
        int max = 0;
        Node temp = root;
        for(int i=31;i>=0;i--){
            int b = (n>>i)&1;
            if(temp == null)
                return -1;
            if(temp.contains(1-b)){
                max = max | (1<<i);
                temp = temp.get(1-b);
            }
            else
                temp = temp.get(b);
        }
        return max;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] q = new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }
        Arrays.sort(q, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        int ans[] = new int[queries.length];
        Trie root = new Trie();
        int j = 0;
        for(int i=0;i<queries.length;i++){
            while(j<nums.length && nums[j]<=q[i][1]){
                root.insert(nums[j++]);
            }
            ans[q[i][2]] = root.getMax(q[i][0]);
        }
        return ans;
    }
}