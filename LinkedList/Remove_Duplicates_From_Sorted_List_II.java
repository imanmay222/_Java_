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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        HashMap<Integer,Integer> hm=new HashMap<>();

        while(curr!=null){
            if(hm.containsKey(curr.val)){
                hm.put(curr.val,hm.get(curr.val)+1);
            }else{
                hm.put(curr.val,1);
            }curr=curr.next;
        }

        //traverse through the actual linkedlist and check in the hashmap if its count>1 ,thn delete
        ListNode temp=new ListNode(-1);
        temp.next=head;
        curr=temp;
        while(curr!=null && curr.next!=null){
            if(hm.get(curr.next.val)>1){
                curr.next=curr.next.next;
                continue;
            }curr=curr.next;
        }return temp.next;
    }
}