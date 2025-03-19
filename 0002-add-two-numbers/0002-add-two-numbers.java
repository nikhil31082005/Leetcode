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
        ListNode result = new ListNode(100);
        ListNode temp = result;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int carry = 0;

        while(temp1 != null || temp2 != null){
            int val1 = temp1 == null ? 0: temp1.val;
            int val2 = temp2 == null ? 0: temp2.val;

            int sum = val1 + val2 + carry;

            int rem = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(rem);
            temp.next = newNode;
            temp = temp.next;

            temp1 = temp1 == null ? null: temp1.next;
            temp2 = temp2 == null ? null: temp2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
            temp = temp.next;
        }
        return result.next;
    }
}