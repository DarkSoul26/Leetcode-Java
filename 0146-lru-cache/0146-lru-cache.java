class Node{
    Node prev;
    Node next;
    int key;
    int val;
    
    Node(int key, int val){
        this.val = val;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> hm;
    int size;
    int currSize;
    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
        size = capacity;
        currSize = 0;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node val = hm.get(key);
            int value = val.val;
            int key1 = val.key;
            val.prev.next = val.next;
            val.next.prev = val.prev;
            Node x = new Node(key1, value);
            Node temp = head.next;
            head.next = x;
            x.prev = head;
            x.next = temp;
            temp.prev = x;
            
            hm.put(key, x);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node rem = hm.get(key);
            rem.prev.next = rem.next;
            rem.next.prev = rem.prev;
            hm.remove(key);
            currSize--;
        }
        if(size==currSize){
            Node rem = tail.prev;
            tail.prev = rem.prev;
            rem.prev.next = tail;
            hm.remove(rem.key);
            currSize--;
        }
        
        Node temp = head.next;
        Node add = new Node(key, value);
        head.next = add;
        add.prev = head;
        add.next = temp;
        temp.prev = add;
        currSize++;
        hm.put(key, add);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */