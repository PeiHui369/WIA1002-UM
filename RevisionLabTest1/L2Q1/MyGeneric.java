public class MyGeneric <E>{
    private E e;

    public MyGeneric(){};

    public E gete(){
        return this.e;
    }

    public void sete(E newe){
        this.e = newe;
    }
}


