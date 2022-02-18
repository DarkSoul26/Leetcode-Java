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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode finalAns = new ListNode();
        ListNode l3 = finalAns;
        int carry = 0;
        while(l1!=null || l2!=null){
            if(l1 == null){
                if(l2.val+carry > 9){
                    l3.next = new ListNode((l2.val+carry)%10);
                    carry = 1;
                }
                else{
                    l3.next = new ListNode(l2.val+carry);
                    carry = 0;
                }
                l2 = l2.next;
            }
            else if(l2 == null){
                if(l1.val+carry > 9){
                    l3.next = new ListNode((l1.val+carry)%10);
                    carry = 1;
                }
                else{
                    l3.next = new ListNode(l1.val+carry);
                    carry = 0;
                }
                l1 = l1.next;
            }
            else{
                if(l1.val+carry+l2.val > 9){
                    l3.next = new ListNode((l1.val+carry+l2.val)%10);
                    carry = 1;
                }
                else{
                    l3.next = new ListNode(l1.val+carry+l2.val);
                    carry = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            System.out.print(l3.val+" ");
            l3 = l3.next;
        }
        if(carry == 1){
            l3.next = new ListNode(1);
        }
        return finalAns.next;
    }
}