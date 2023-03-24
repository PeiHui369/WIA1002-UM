package Slist;
public class SNode<E>{
    E item;
    SNode<E> next;

    public SNode(){  //No accept parameters, initialize as null
        item = null;
        next = null;
    }

    public SNode(E item){
        this.item = item;
        this.next = next;
    }

    public SNode(E newItem, SNode<E> newNext){
        this.item = newItem;
        this.next = newNext;
    }
}
