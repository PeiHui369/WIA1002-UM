public class StorePairGeneric<E> {

    private E first, second;

    public StorePairGeneric(E first, E second){
        this.first = first;
        this.second = second;
    }

    public E getFirst(){
        return first;
    }

    public E getSecond(){
        return second;
    }

    public void setPair(E first, E second){
        this.first = first;
        this.second = second;
    }

    public String toString(){
        return "first = " + first + " second = " + second;
    }
}
