class MyHashMap {
    Node parent;
    public MyHashMap() {
        parent = new Node();
    }
    
    public void put(int key, int value) {
        Node tempP = parent;
        while(tempP.next!=null){
            if(key == tempP.key){
                tempP.value = value;
                return;
            }
            tempP = tempP.next;
        }
        if(tempP.key == key){
            tempP.value = value;
            return;
        }
        tempP.next = new Node(key, value);
    }
    
    public int get(int key) {
        Node tempP = parent;
        if(parent.next == null && parent.key == key)
            return -1;
        while(tempP!=null){
            // System.out.print(tempP.key+" ");
            if(key == tempP.key){
                return tempP.value;
            }
            tempP = tempP.next;
        }
        // System.out.println();
        return -1;
    }
    
    public void remove(int key) {
        Node tempP = parent;
        Node prev = parent;
        while(tempP!=null){
            if(key == tempP.key){
                prev.next = tempP.next;
                return;
            }
            prev = tempP;
            tempP = tempP.next;
        }
       
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node(){}
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */