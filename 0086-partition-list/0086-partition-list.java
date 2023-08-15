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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode temp = l1;
        ListNode temp1 = l2;
        while(head!=null){
            if(head.val<x){
                l1.next=new ListNode(head.val);
                l1=l1.next;
            }
            else{
                l2.next=new ListNode(head.val);
                l2=l2.next;
            }
            head=head.next;
        }
        l1.next=temp1.next;
        return temp.next;
    }
}