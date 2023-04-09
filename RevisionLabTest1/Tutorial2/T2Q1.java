package tutorial2;
public class Container<T> {
    private T t;
    Container(){}
    public void add(T para){
        this.t = para;
    }

    public T retrieve(){
        return t;
    }

    public static void main(String[] args) {
        Container<Integer> intcon = new Container<>();
        Container<String> strcon = new Container<>();
        intcon.add(5);
        strcon.add("Java");
        System.out.println(intcon.retrieve());
        System.out.println(strcon.retrieve());
    }

}
