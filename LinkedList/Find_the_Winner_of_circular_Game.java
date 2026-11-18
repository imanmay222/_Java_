class Solution {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    Node head=null;
    int size=0;
    //using the concept of linkedlist.
    void addLast(int data){
        Node node=new Node(data);
        size++;
        if(head==null){
            head=node;
            head.next=null;
            return;
        }

        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=node;
    }

    

    public int findTheWinner(int n, int k) {
        for(int i=1;i<=n;i++){
            addLast(i);
        }
        
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=head; //made the circular linkedlist

        
        Node prev=temp;
        Node curr=head;
        //traverse and remove
        while(size!=1){
            for(int i=1;i<k;i++){
                prev=curr;
                curr=curr.next;
            }
            prev.next=curr.next;
            curr=prev.next;
            size--;
        }return curr.data;
    }
}