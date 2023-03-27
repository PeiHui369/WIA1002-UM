import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack <E>{
    //Create a generic stack using ArrayList
    ArrayList<E> stack = new ArrayList<>();

    public void push(E o){
        stack.add(o);
    }

    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E ele = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return ele;
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.get(stack.size()-1);
    }

    public int getSize(){
        return stack.size();

    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }

    public String toString(){
        return "Stack: " + stack.toString();
    }

    public boolean search(E o){
        return stack.contains(o);
    }
}

/*
In the pop() method, after getting the element from the stack using stack.get(stack.size()-1), it is recommended to set that element to null before removing it from the list. 
This is to avoid potential memory leaks if the element is a reference to a larger object that is no longer needed. 
The modified code for the pop() method would look like:

public E pop(){
    if(isEmpty()){
        throw new EmptyStackException();
    }
    E ele = stack.get(stack.size()-1);
    stack.set(stack.size()-1, null); // set the element to null
    stack.remove(stack.size()-1);
    return ele;
}

*/

//@own
