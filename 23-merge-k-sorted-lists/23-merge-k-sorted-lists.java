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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                minHeap.add(temp);
                temp = temp.next;
            }
        }
        ListNode ans = new ListNode();
        ListNode ansFinal = ans;
        while(!minHeap.isEmpty()){
            ListNode temp1 = minHeap.poll();
            ansFinal.next = temp1;
            ansFinal = ansFinal.next;
        }
        ansFinal.next = null;
        return ans.next;
    }
}