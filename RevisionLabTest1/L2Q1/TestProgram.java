public class TestProgram {
    public static void main(String[] args) {
        MyGeneric<String> strObj = new MyGeneric<String>();
        MyGeneric<Integer> intObj = new MyGeneric<Integer>();
        strObj.sete("six");
        System.out.println(strObj.gete());
        intObj.sete(6);
        System.out.println(intObj.gete());
    }
}
