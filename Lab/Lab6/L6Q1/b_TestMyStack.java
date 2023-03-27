public class TestMyStack {
    public static void main (String[] args){
        MyStack<Character> stack = new MyStack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.toString());
        System.out.println("'b' exist? " + stack.search('b'));
        System.out.println("'k' exist? " + stack.search('k'));
    }
}
