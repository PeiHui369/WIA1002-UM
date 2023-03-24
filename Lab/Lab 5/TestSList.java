package Slist;

public class TestSList {
    public static void main(String[] args) {
        SList<String> myList = new SList<>();

        //1) Append the following values individually: "Linked list, is, easy."
        myList.appendEnd("Linked");
        myList.appendEnd("list,");
        myList.appendEnd("is,");
        myList.appendEnd("easy.");

        //2) Display these values
        System.out.println("List values: ");
        myList.display();

        //3) Remove the word "Linked list" and display the remove value
        String removed = myList.removeInitial();
        System.out.println("Remove value: " + removed);

        //4) Check if 'difficult' is in the list
        System.out.println("Does the list contain 'difficult'? " + myList.contains("difficult"));

        //5) Clear the list
        myList.clear();
    }
}
