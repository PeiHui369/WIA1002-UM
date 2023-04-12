package Task3;

public class Main {
    public static void main(String[] args) {
        // Create Node objects for each person
        Node<String> you = new Node<>("You");
        Node<String> alice = new Node<>("Alice");
        Node<String> bob = new Node<>("Bob");
        Node<String> frank = new Node<>("Frank");
        Node<String> elsa = new Node<>("Elsa");
        Node<String> dave = new Node<>("Dave");

// Establish relationships between nodes
        you.setEdge1("friend", alice);
        alice.setEdge1("husband", bob);
        bob.setEdge1("father", frank);
        frank.setEdge1("married", elsa);
        elsa.setEdge1("boss", dave);

// Traverse the graph to find the killer
        Node<String> killer = dave.traverse("subordinate")
                .traverse("husband")
                .traverse("son")
                .traverse("wife")
                .traverse("friend");

        System.out.println("The killer is: " + killer.getValue());

    }
}
