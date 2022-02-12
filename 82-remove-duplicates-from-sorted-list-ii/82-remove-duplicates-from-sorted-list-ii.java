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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode trav = head;
        ListNode prev = new ListNode();
        ListNode ans = prev;
        prev.next = head;
        while(trav!= null){
            boolean flag = false;
            while(trav.next!=null && trav.val == trav.next.val){
                trav = trav.next;
                flag = true;
            }
            if(flag){
                if(trav.next != null){
                    prev.next = trav.next;
                }
                else
                    prev.next = null;
            }
            else
                prev = trav;
            trav = trav.next;
            
        }
        return ans.next;
    }
}