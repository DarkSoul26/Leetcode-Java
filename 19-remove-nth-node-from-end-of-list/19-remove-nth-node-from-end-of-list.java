/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode temp1 = head;
        int len=0,i=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        if(n==len){
            head=head.next;
            return head;
        }
        while(i<len-n-1){
            temp1=temp1.next;
            i++;
        }
        if(temp1.next.next!=null)
            temp1.next=temp1.next.next;
        else
            temp1.next=null;
        return head;
    }
}