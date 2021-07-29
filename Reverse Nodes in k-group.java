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
    public ListNode reverselist( ListNode head, int k)
    {
        ListNode newhead=null;
        ListNode ptr=head;
        while(k>0)
        {
            ListNode nextnode=ptr.next;
            ptr.next=newhead;
            newhead=ptr;
            ptr=nextnode;
            k--;
        }
        return newhead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode ptr=head;
        while(count<k && ptr!=null)
        {
            ptr=ptr.next;
            count++;
        }
        if(count==k)
        {
            ListNode reversehead=this.reverselist(head,k);
            head.next=this.reverseKGroup(ptr,k);
                return reversehead;
        }
        return head;
        
    }
}
//TC-O(N) RECURSION
//SC-O(N/K)