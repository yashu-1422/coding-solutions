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
        
        // Dummy node helps us easily build the result linked list
        ListNode dummy = new ListNode(0);
        
        // 'current' will move and help us attach new nodes
        ListNode current = dummy;
        
        // carry will store extra value when sum > 9
        int carry = 0;

        // Continue loop while:
        // 1. l1 still has nodes
        // 2. l2 still has nodes
        // 3. carry still exists
        while (l1 != null || l2 != null || carry != 0) {

            // If l1 is not null take its value
            // otherwise use 0
            int val1 = (l1 != null) ? l1.val : 0;

            // If l2 is not null take its value
            // otherwise use 0
            int val2 = (l2 != null) ? l2.val : 0;

            // Add values from both lists and carry
            int sum = val1 + val2 + carry;

            // Update carry for next addition
            carry = sum / 10;

            // Digit to store in current node
            int digit = sum % 10;

            // Create a new node with the digit
            current.next = new ListNode(digit);

            // Move current pointer forward
            current = current.next;

            // Move l1 to next node if it exists
            if (l1 != null) {
                l1 = l1.next;
            }

            // Move l2 to next node if it exists
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // dummy node was just helper
        // actual result starts from dummy.next
        return dummy.next;
    }
}