/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> al = new ArrayList<>();
        while(head!=null){
            if(al.contains(head))
                return head;
            al.add(head);
            head = head.next;
        }
        return null;
    }
}