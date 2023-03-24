/*Implement class:
Instant variable = head, size
 */
//Type: String (Student names)
package Slist;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentList {
    private SNode<String> head;
    private int size;

    public StudentList(){
        this.head = null;
        this.size = 0;
    }
    public void add(String e){
        SNode<String> newNode = new SNode<>(e);
        if (head == null){
            head = newNode;
        }else{
            //This same as addLast, which insert when the value is null
            SNode<String> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void removeElement(String e){
        if(head == null){
            return;
        }
        if(head.item.equals(e)){
            head = head.next;
            size--;
            return;
        }
        SNode<String> current = head;
        while(current.next != null){                    //if next not null
            if(current.next.item.equals(e)){            //if the next ele of this is e
                current.next = current.next.next;       //then set the next ele of this is the next of e, therefore skipped e
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("The list is empty.");
            return;
        }
        SNode<String> current = head;
        while(current != null){
            System.out.println(current.item);
            current = current.next;
        }
    };

    public int getSize(){
        return size;
    };

    public boolean contains(String e){
        SNode<String> current = head;
        while(current != null){
            if(current.item.equals(e)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void replace (String e, String newE){
        SNode<String> current = head;
        while(current != null){
            if(current.item.equals(e)){
                current.item = newE;
                return; // is used to immediately exit a method before reaching the end of the method's code
            }
            current = current.next;
        }
    }
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        StudentList list = new StudentList();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i<=numStudents; i++){
            System.out.print("Enter student " + i + " name: ");
            String name = scanner.nextLine();
            list.add(name);
        }

        System.out.println("\nList of students:");
        list.printList();

        System.out.println("\nNumber of students: " + list.getSize());

        System.out.print("\nEnter the name of the student you want to replace: ");
        String nameToReplace = scanner.nextLine();
        if(list.contains(nameToReplace)){
            System.out.print("Enter the new name for the student: ");
            String newName = scanner.nextLine();
            list.replace(nameToReplace, newName);
            System.out.println("\nUpdated list of students: ");
            list.printList();
        }else{
            System.out.println("The student name you entered was not found.");
        }

        System.out.print("\nEnter the name of the student you want to remove: ");
        String nameToRemove = scanner.nextLine();
        if(list.contains(nameToRemove)){
            list.removeElement(nameToRemove);
            System.out.println("\nUpdated list of students:");
            list.printList();
        }else{
            System.out.println("The student name you entered was not found.");
        }
    }
}
