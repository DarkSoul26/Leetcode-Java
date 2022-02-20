class MyLinkedList {
    Node head;
    public MyLinkedList() {
        head = new Node();
    }
    
    public int get(int index) {
        Node temp = head;
        index++;
        while(temp.next!=null && index--!=0){
            temp = temp.next;
        }
        if(index <= 0)
            return temp.val;
        return -1;
    }
    
    public void addAtHead(int val) {
        if(head == null){
            Node newHead = new Node(val);
            head = newHead;
            return;
        }
        Node newHead = new Node(val);
        newHead.next = head.next;
        head.next = newHead;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            Node newHead = new Node(val);
            head = newHead;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new Node(val);
    }
    
    public void addAtIndex(int index, int val) {
        int i = 0;
        Node temp = head;
        if(head == null){
            if(index == 0)
                head = new Node(val);
            return;
        }
        while(temp.next!=null){
            if(i == index){
                Node newN = new Node(val);
                newN.next = temp.next;
                temp.next = newN;
                return;
            }
            temp = temp.next;
            i++;
        }
        if(temp.next == null && i==index){
            temp.next = new Node(val);
        }      
    }
    
    public void deleteAtIndex(int index) {
        Node temp = head;
        int i = 0;
        if(temp == null)
            return;
        while(temp.next!=null){
            if(i == index){
                if(temp.next.next!=null)
                    temp.next = temp.next.next;
                else
                    temp.next = null;
                return;
            }
            temp = temp.next;
            i++;
        }
    }
}

class Node{
    int val;
    Node next;
    Node(){}
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */