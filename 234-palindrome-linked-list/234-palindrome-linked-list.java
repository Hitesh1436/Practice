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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode start = head;
        while(start != null){
            st.push(start);
            start = start.next;
        }
        while(head != null && !st.isEmpty()){
            if(st.pop().val !=head.val){
                return false;
            }else{
                head= head.next;
            }
        }
        return true;
    }
}