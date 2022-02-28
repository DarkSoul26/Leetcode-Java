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
    public void swapP(ListNode head){
        if(head==null){
            return;
        }
        else if(head.next==null){
            return;
        }
        int temp=head.val;
        head.val=head.next.val;
        head.next.val=temp;
        swapP(head.next.next);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode t=head;
        swapP(head);
        return t;
    }
}