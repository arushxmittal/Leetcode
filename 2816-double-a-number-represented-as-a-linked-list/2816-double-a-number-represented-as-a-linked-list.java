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
    public ListNode doubleIt(ListNode head) {
        ListNode second = reverse(head);
        ListNode result = second;
        ListNode prev = null;
        int carry = 0;
        while(second != null){
            int n = second.val*2 + carry;
            second.val = n%10;
            carry = n/10;
            prev = second;
            second = second.next;
        }
        if(carry != 0){
            ListNode carryNode = new ListNode(carry);
            prev.next = carryNode;
        }
        return reverse(result);
    }
    
    public ListNode reverse(ListNode head){
        ListNode first = head;
        ListNode prev = null;

        while(first != null){
            ListNode second = first.next;

            first.next = prev;
            prev = first;
            first = second;
        }
        return prev;
    }
}