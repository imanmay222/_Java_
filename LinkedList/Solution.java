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

    ListNode res=new ListNode(-1);

    void addLast(int val){
        if(res==null){
            res=new ListNode(val);
            res.next=null;
            return;
        }
        ListNode curr=res;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=new ListNode(val);
        curr.next.next=null;
    }

    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> left=new ArrayList<>();
        ArrayList<Integer> right=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            int val=curr.val;
            if(val>=x){
                right.add(val);
            }else{
                left.add(val);
            }

            curr=curr.next;
        }

        
        for(int i=0;i<left.size();i++){
            addLast(left.get(i));
        }
        for(int i=0;i<right.size();i++){
            addLast(right.get(i));
        }

        return res.next;
    }

}