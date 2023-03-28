import java.util.Arrays;
import java.util.LinkedList;

public class MyQueue<E>{ //Generic queue class MyQueue using LinkedList
    private LinkedList<E> queue;

    //Constructor that creates a queue with the given elements
    public MyQueue(E[] e){
        queue = new LinkedList<E>();
        for(int i = 0; i<e.length; i++){
            queue.add(e[i]);
        }
    }

    //Default constructor that creates an empty queue
    public MyQueue(){
        queue = new LinkedList<E>();
    }

    //Add an element to the end of the queue
    public void enqueue(E e){
        queue.addLast(e);
    }

    //Remove and return the first element of the queue
    public E dequeue(){
        return queue.removeFirst();
    }

    //Get the element at the given index
    public E getElement(int i){
        return queue.get(i);
    }

    //Get the first element of the queue without removing it
    public E peek(){
        return queue.peek();
    }

    //Get the number of elements in the queue
    public int getSize(){
        return queue.size();
    }

    //Check if the queue contains the given element
    public boolean contains(E e){
        return queue.contains(e);
    }

    //Check if the queue is empty
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    //Get a string representation of the queue
    public String toString(){
        return queue.toString();
    }
}
