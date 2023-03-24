package T5;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    private class Node{
        char data;
        Node prev;
        Node next;

        Node(char data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public void add(char data){
        Node newNode = new Node(data); //Create a new 'Node' object called 'newNode' with the given 'data'
        if(head == null){              //If the linked list is currently empty(i.e. the 'head' reference is 'null'), it sets both the 'head' and 'tail' reference to 'newNode'
            head = newNode;
            tail = newNode;
        }else{                         //If the linked list is not empty
            tail.next = newNode;       //it sets the 'next' reference of the current 'tail' node to 'newNode'
            newNode.prev = tail;       //and sets the 'prev' reference of 'newNode' to the current 'tail' node
            tail = newNode;            //Finally, it sets the 'tail' reference to 'newNode' since 'newNode' is now the last node in the list
        }
        //Note that the 'addLast()' method simply calls the 'add()' method, since adding a node to the end of the list is equivalent to adding it to the list.
    }

    public void addLast(char data){
        add(data);
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

        //Add 'a', 'b', and 'c' to the list
        list.add('a');
        list.add('b');
        list.add('c');

        //Add a new node containing 'z' to the end of the list
        list.addLast('z');

        //Print the list
        list.printList(); //Output: a b c z
    }
}
