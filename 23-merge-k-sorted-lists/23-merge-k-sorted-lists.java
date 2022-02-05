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
        List<ListNode> al = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                al.add(temp);
                // minHeap.add(temp);
                temp = temp.next;
            }
        }
        ListNode ans = new ListNode();
        ListNode ansFinal = ans;
        Collections.sort(al, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val-b.val;
            }
        });
        for(int i=0;i<al.size();i++){
            // ListNode temp1 = minHeap.poll();
            ListNode temp1 = al.get(i);
            ansFinal.next = temp1;
            ansFinal = ansFinal.next;
        }
        ansFinal.next = null;
        return ans.next;
    }
}