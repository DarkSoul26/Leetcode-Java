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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalAns = new ListNode(0);
        ListNode traverse = finalAns;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                traverse.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else{
                traverse.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            traverse = traverse.next;
        }
        
        while(list1!=null){
            traverse.next = new ListNode(list1.val);
            list1 = list1.next;
            traverse = traverse.next;
        }
        while(list2!=null){
            traverse.next = new ListNode(list2.val);
            list2 = list2.next;
            traverse = traverse.next;
        }
        
        return finalAns.next;
    }
}