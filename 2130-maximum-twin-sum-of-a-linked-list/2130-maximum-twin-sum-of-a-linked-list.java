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
    public int pairSum(ListNode head) {
        List<Integer> al = new ArrayList<>();
        while(head!=null){
            al.add(head.val);
            head = head.next;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0,j=al.size()-1;(i<al.size()/2 && j>=al.size()/2);i++,j--){
            if(al.get(i)+al.get(j)>max)
                max = al.get(i)+al.get(j);
        }
        return max;
    }
}