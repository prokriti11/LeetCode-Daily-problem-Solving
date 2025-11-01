class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
       boolean[] hasN = new boolean[100001];
       for(int x : nums) hasN[x] = true;
       ListNode dummy = new ListNode(0, head);
       ListNode prev = dummy;
       for(ListNode curr = head; curr!= null; curr = curr.next){
        if(hasN[curr.val])
            prev.next = curr.next;
        else 
            prev = prev.next;
       } 
       return dummy.next;
    }
}