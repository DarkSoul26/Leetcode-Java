/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int c1=0,c2=0;
        while(temp1!=null){
            temp1=temp1.next;
            c1++;
        }
        while(temp2!=null){
            temp2=temp2.next;
            c2++;
        }
        ListNode h1;
        ListNode h2;
        if(c1>c2){
            h1=headA;
            h2=headB;
        }
        else{
            h1=headB;
            h2=headA;
        }
        int tc=0;
        while(tc!=Math.abs(c1-c2)){
            h1=h1.next;
            tc++;
        }
        while(h1!=null && h2!=null){
            if(h1==h2)
                return h1;
            h1=h1.next;
            h2=h2.next;
        }
        return null;
    }
}