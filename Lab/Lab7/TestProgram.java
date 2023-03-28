public class TestProgram {
    public static void main(String[] args) {
        // a. Have an initialize queue items consists of Durian and Blueberry in a fruitQ

        String[] fruit = {"Durian", "Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(fruit);

        // b. Then add new items in the following order: Apple, Orange, Grapes, Cherry.
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");
            //For loop another array faster

        // c. Display the queue.
        System.out.println("fruitQ queue display: " + fruitQ);

        // d. Show the top item.
        System.out.println("The top item: "+ fruitQ.peek());

        // e. Get the queue size.
        System.out.println("The queue size: " +fruitQ.getSize());

        // f. Delete Durian.
        System.out.println(fruitQ.dequeue());
        System.out.println("After delete Durian: " + fruitQ);

        // g. Get item in index position of 2
        System.out.println("Item in index position of 2: " + fruitQ.getElement(1));

        // h. Check whether the queue consists of Cherry
        System.out.println("Does the queue consists of Cherry? " +fruitQ.contains("Cherry"));

        // i. Check whether the queue consists of Durian
        System.out.println("Does the queue consists of Durian? " +fruitQ.contains("Durian"));

        // j. Display the queue using the isEmpty() condition
        System.out.println("Is the queue empty? " +fruitQ.isEmpty());

    }
}
