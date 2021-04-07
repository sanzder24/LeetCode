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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        int c=0;
        while(first!=null){
            c++;
            first=first.next;
        }
      
        int i=0;
        while(i< (c-n)-1){
            second=second.next;
            i++;
        }
        second.next = second.next.next;
        return head;
    }
}