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
    static ListNode start;
    public boolean isPalindrome(ListNode head) {
     
        start = head;
        return rev(head);
    }
    
    public boolean rev(ListNode head) {
		if(head==null)
			return true;
		boolean temp = rev(head.next);
		if(head.val==start.val && temp)
		{
			start = start.next;
			return true;
		}
		else
			return false;
	}
}