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
    public int size(ListNode node){
        ListNode curr = node;
        int count = 0;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        return count;
    }
    
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = size(head);
        int one = size/k;
        int rem = size%k;
        
        ListNode[] array = new ListNode[k];
        
        ListNode curr = head;
        int idx= 0;
        while(curr!=null){
            // System.out.println(idx);
            array[idx] = curr;
            int count = 1;
            while(curr!=null && count++ < one){
                curr = curr.next;
            }
            
            if(rem > 0 && curr!=null && one > 0){
                curr = curr.next;
                rem--;
            }
            
            if(curr== null || curr.next==null){
                break;
            }
            ListNode fnode = curr.next;
            curr.next = null;
            curr = fnode;
            idx++;
        }
        
        
        return array;
    }
}
