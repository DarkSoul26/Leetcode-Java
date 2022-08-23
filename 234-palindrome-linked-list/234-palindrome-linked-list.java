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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        ListNode temp = head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(fast!=null && fast.next == null)
            slow = slow.next;
        prev.next = null;
        ListNode newPrev = null;
        ListNode curr = slow;
        ListNode next = slow;
        while(curr!=null){
            next = curr.next;
            curr.next = newPrev;
            newPrev = curr;
            curr = next;
        }
        while(head!=null && newPrev!=null){
            if(head.val!=newPrev.val)
                return false;
            head = head.next;
            newPrev = newPrev.next;
        }
        
        if(head!=null || newPrev!=null)
            return false;
        return true;
    }
}