package L4Q1;

import L4Q1.Node;

import java.util.NoSuchElementException;

public class MyLinkedList<E> { //#LinkedList with Generic Class
    //PRIVATE instance variable
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList(){} //PUBLIC default constructor

    public void addFirst(E e){
        Node<E> newNode = new Node<E>(e,head);
        head = newNode;
        if(tail == null){
            tail = newNode;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newNode = new Node<E>(e, null); //Last ele, no next
        if(tail == null){ //if no ele
            head = newNode;
        }else{
            tail.next = newNode; //add to next of the current tail
        }
        tail = newNode; //change the tail pointer to newNode
        size++;
    }

    public void add(E e){
        addLast(e);
    }

    public void add(int index, E e){
        checkIndex(index);
        if(index == 0){
            addFirst(e);
        }else if(index == size){ //=size as will become more one ele with oriLastIndex+1=oriSize
            addLast(e);
        }else{
            linkAfter(e,node(index-1));
        }
    }

    private boolean indexValid(int index){
        return index>=0 || index<size;
    }

    private void checkIndex(int index){
        if(!indexValid(index)){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private String outOfBoundMsg(int index){
        return String.format("Index: %d, Size: %d",index, size);
    }

    void linkAfter(E e, Node<E> prev){
        final Node<E> newNode = new Node<E>(e, prev.next);
        prev.next = newNode;
        size++;
    }

    Node<E> node (int index){
        Node<E> node = head;
        for(int i = 0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    public E removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        E element = head.element;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return element;
    }

    public E removeLast(){
        if(tail == null){
            throw new NoSuchElementException();
        }
        E element = tail.element;

        if(head.equals(tail)){ //if head and tail same (only 1 ele), then once remove, all null
            head = tail = null;
        }else {
            Node<E> prev = node(size - 2);
            prev.next = null;
            tail = prev;
            size--;
        }
        return element;
    }

    public E remove(int index){
        checkIndex(index);
        if(index == 0){
            removeFirst();
        }else if(index==(size-1)){
            removeLast();
        }
        final Node<E> prev = node(index-1);
        E element = prev.next.element;
        prev.next = prev.next.next;
        size--;
        return element;
    }

    public boolean contains(E element){
        return indexOf(element) >= 0 && indexOf(element) < size;
    }

    public E get(int index){
        return node(index).element;
    }

    public E getFirst(){
        return head.element;
    }

    public E getLast(){
        return tail.element;
    }

    public int indexOf(E e){
        int index = 0;
        if(e == null){ //null value is acceptable
            for(Node<E> node = head; node!= null; node = node.next){
                if(node.element == e){
                    return index;
                }
                index++;
            }
        }else{
            for(Node<E> node = head; node!= null; node = node.next){
                if(node.element.equals(e)){
                    return index;
                }
                index++;
            }
        }
        /* Why cannot use this?
        Node<E> current = head;
        for(int i = 0; i<size; i++){
            if(current.element.equals(e)){
                return i;
            }
        }
        */
        return -1;
    }

    public int lastIndexOf(E e){
        int index = -1;
        int i = 0;
        if(e == null){
            for(Node<E> node = head; node!=null; node=node.next){
                if(node.element == e){
                    index = i; //#
                }
                i++; //#
            }
        }else{
            for(Node<E> node = head; node!=null; node=node.next){
                if(node.element.equals(e)){
                    index = i;
                }
                i++;
            }
        }
        return index; //#
    }

    public E set(int index, E e){
        checkIndex(index);
        Node<E> node = node(index); //store position in node
        E oldVal = node.element; //store position's value in oldVal
        node.element = e;
        return oldVal;
    }

    //?
    public void clear(){
        for(Node<E> slow = head; slow!=null;){
            Node<E> fast = slow.next;
            slow.next = null;
            slow.element = null;
            slow = fast;
        }
        head = tail = null;
        size = 0;
    }

    /*
    The code you provided is a Java method that clears a singly linked list by removing all of its nodes and setting the size to zero.
    It does this by iterating through the list using two pointers: 'slow' and 'fast'. The 'slow' pointer starts at the head of the list and the 'fast' pointer starts at the node next to the 'slow' pointer.
    The 'slow' pointer is used to remove each node by setting its 'element' field to 'null' and its 'next' field to 'null'.
    Then, the 'slow' pointer is moved to the next node using the 'fast' pointer, and the process is repeated until the end of the list is reached.
    Finally, the 'head', 'tail', and 'size' fields are reset to 'null', 'null', and '0', respectively.

    This code runs in O(n) time, where n is the number of nodes in the list, because it needs to visit each node once to clear it. There is no faster method to clear a singly linked list, because you have to visit each node in the list to remove it.

    However, if you have a doubly linked list, you can clear it faster by iterating from both ends of the list at the same time, setting the 'prev' and 'next' fields of each node to 'null'. This runs in O(n/2) time, which is faster than O(n) for large lists.
     */

    public void print(){
        if(head == null && tail==null){
            System.out.println("[]");
        }else{
            Node<E> node = head;
            System.out.print("[");
            for(int i = 0; i<size; i++){
                System.out.print(node.element + ((i==size-1)?"":", "));
                node = node.next;
            }
            System.out.println("]");
        }
    }

    public void reverse(){
        if(head == null & tail == null){
            System.out.println("[ ]");
        }else{
            String s = head.element + "";
            for(Node<E> node = head.next; node!=null; node=node.next){
                s = node.element + ", " +s;
            }
            System.out.printf("[%s]\n",s);
        }
    }
    
    /*
    The code you provided does not actually reverse the linked list. It prints the elements of the linked list in reverse order, but it does not modify the linked list itself.

    To reverse a singly linked list, you need to reverse the links between the nodes. Here is an example implementation in Java:

public void reverse() {
    Node<E> prev = null;
    Node<E> current = head;
    Node<E> next = null;

    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    head = prev;
}


This code iterates through the linked list and reverses the links between the nodes. 
It does this by using three pointers: 'prev', 'current', and 'next'. 
Initially, 'prev' and 'next' are 'null', and 'current' points to the head of the list.
In each iteration of the loop, 'next' is set to the next node in the list, 'current.next' is set to 'prev', 
'prev' is set to 'current', and 'current' is set to 'next'. 
This effectively reverses the links between the nodes. 
Finally, the 'head' pointer is set to 'prev', which is the new head of the list

*/

    public int size() {
        return this.size;
    }

    //Question 2
    public E getMiddleValue(){
        if(size == 0){throw new NoSuchElementException();}
        return node(size/2).element;
    }
}
//?When use Node<E> x or E x
