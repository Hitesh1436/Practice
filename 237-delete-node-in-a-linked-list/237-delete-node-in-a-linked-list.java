/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
        public void deleteNode(ListNode node) {
           if(node != null && node.next != null){
        node.val = node.next.val;
        //  Given 4 -> 5 -> 1-> 9
        // Node to delete = 5

        // step 1 :  4 -> 1 -> 1-> 9
        // step 2 :  4 -> 1 -> 9

        // step 1 :  4 -> 1 -> 1 -> 9
        // we delete this------^
        node.next = node.next.next;
    }
  }
}