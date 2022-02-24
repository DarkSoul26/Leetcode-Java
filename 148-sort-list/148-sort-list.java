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
    public ListNode sortList(ListNode head) 
    {
        ArrayList<Integer> alist = new ArrayList<>();
        ListNode temp = head;
        while(temp != null)
        {
            alist.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(alist);
        ListNode dummy = new ListNode(-1);
        ListNode fakeHead = dummy;
        
        for(int i=0;i<alist.size();i++)
        {
            fakeHead.next = new ListNode(alist.get(i));
            fakeHead=fakeHead.next;
        }
        return dummy.next;
    }
}