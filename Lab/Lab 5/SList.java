package Slist;

public class SList<E> {
    private SNode<E> head; //head of the list
    private int size; //size of the list

    //default constructor
    public SList(){
        this.head = null;
        this.size = 0;
    }

    //constructor that receives a generic item
    public SList(E item){
        this.head = new SNode<>(item);
        this.size = 1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void addFirst(E newItem){
        head = new SNode<>(newItem, head);
        size++;
    }

    public void addLast(E newItem){
        if(isEmpty()){
            addFirst(newItem);
        }else{
            SNode<E> current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new SNode<>(newItem, null);
            size++;
        }
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }else{
            E temp = head.item;
            head = head.next;
            size--;
            return temp;
        }
    }

    public E getFirst(){
        if(isEmpty()){
            return null;
        }else{
            return head.item;
        }
    }

    //----Above are the necessary declaration of class----
    public void appendEnd(E e){
        //Append a new element at the end of the list
        SNode<E> newNode = new SNode<>(e);

        if(head == null){
            head = newNode;
        }else{
            SNode<E> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public E removeInitial(){
        //Eliminate the first element in the list
        if(head == null){
            return null;
        }

        E removedItem = head.item;
        head = head.next;
        size--;

        return removedItem;
    }

    public boolean contains(E e){
        //Search for an element and returns true if this list contains the searched element
        SNode<E> current = head;
        while (current != null){
            if(current.item.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        //Empty all elements in the list and return a statement that reports that the list is empty
        head = null;
        size = 0;
        System.out.println("The list is now empty.");
    }

    public void display(){
        //Display all values from the list in a successive order
        SNode<E> current = head;
        while(current != null){
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}
