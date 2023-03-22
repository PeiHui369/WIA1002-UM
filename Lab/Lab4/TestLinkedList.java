package L4Q1;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> l = new MyLinkedList<>();

        //a)
        for (char ch = 'a'; ch <= 'e'; ch++) {
            l.add(ch);
        }

        //b
        l.print();

        //c
        l.reverse();

        //d
        System.out.println("Number of elements: " +l.size());

        //e
        System.out.println("First value: " +l.getFirst());
        System.out.println("Last value: " +l.getLast());

        //f
        l.remove(2);

        //g: Retrieve the index location for the second and third value
       System.out.printf("Second value = %c, Third value = %c\n",l.get(1),l.get(2));

        //h
        System.out.println(l.contains('c'));

        //i
        l.clear();
        l.addFirst('j');
        l.add('a');
        l.add('v');
        l.addLast('a');
        l.print();

        //getMiddleValue
        System.out.println("Middle value: " + l.getMiddleValue());
    }
}

//When need to use .element when node is enough?
//When use Node <E> ele or E ele
