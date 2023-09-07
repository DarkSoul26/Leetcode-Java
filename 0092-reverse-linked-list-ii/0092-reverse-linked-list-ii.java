class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode current=head;
        if(left==right){
            return current;
        }
           ListNode temp=head;
           ListNode temp1=head;
            ListNode prev=head;
        for(int i=1;i<left;i++){        //edit 1
            //if(current.next!=null){
                current=current.next;
            if(i<left-1)
                prev=prev.next;
            //}
        }
        for(int i=1;i<=right;i++){
            //if(temp1.next!=null){      //edit2
            temp1=temp1.next;
           // }
        }
    
       ListNode cur= current;
       //ListNode prev= current;         //edit 3
    
       ListNode node= reverse(cur,left,right);
        prev.next=node;
        
        ListNode fin=prev;              //edit4
       while(fin.next!=null){
           fin= fin.next;
       }
        fin.next=temp1;
        if(left==1)
            return head.next;
        return head;                    //edit5
    }
    
    ListNode reverse(ListNode node, int left, int right)
    {
         ListNode nodef= new ListNode(node.val);
         if(node.next!=null){
            node = node.next;
             for(int i=left+1;i<=right;i++){
                 ListNode newNode= new ListNode(node.val);
                 newNode.next=nodef;
                 nodef= newNode;
                if(node.next!=null){
                     node = node.next;
                }
             }
         }
         
        return nodef;
    }
    
}