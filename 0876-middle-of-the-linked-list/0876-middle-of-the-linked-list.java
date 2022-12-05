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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int len=0,i=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        while(i!=len/2){
            head=head.next;
            i++;
        }
        return head;
    }
}