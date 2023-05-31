package FullStackStackQueue;

public class MinStack {

    private class Node{
        int val;
        int min;
        Node next;

        private Node(int val, int min){
            this(val, min, null);
        }

        private Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public void push(int x){
            if(head == null) {
                head = new Node(x, x); //val = min where next=null for head
            }else{
                head = new Node(x, Math.min(x, head.min), head); //everytime new element pass in will compare with the original min stored in head
            }
    }

    public void pop(){
        head = head.next;
    }

    public int getMin(){
        return head.min;
    }
}
