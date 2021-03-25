class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur= head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev =dummy;
        while(cur!=null){
            if(cur.val ==val){
                prev.next=cur.next;
            }
            else{
                prev= prev.next;
            }
            cur =cur.next;
            
        }
        return dummy.next;
    }
}