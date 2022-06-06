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
        // putting the value of next node into our current node
        node.val = node.next.val;
        
        // our list looks like:
        // 4->1->1->9->null
        
        // connecting node to 9, deleting the mid 1
        node.next = node.next.next;
    }
  }
}