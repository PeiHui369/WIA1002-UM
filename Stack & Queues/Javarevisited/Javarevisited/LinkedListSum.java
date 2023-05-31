import java.util.Stack;

public class LinkedListSum {
    private static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode sumLinkedLists(ListNode head1, ListNode head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Push values of linked list 1 onto stack 1
        while (head1 != null) {
            stack1.push(head1.value);
            head1 = head1.next;
        }

        // Push values of linked list 2 onto stack 2
        while (head2 != null) {
            stack2.push(head2.value);
            head2 = head2.next;
        }

        ListNode result = null;
        int carry = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;

            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }

            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;
        }

        return reverseLinkedList(result);
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        // Create linked list 1: 1-2-3-4-5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        // Create linked list 2: 6-7-8-9-10
        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(8);
        head2.next.next.next = new ListNode(9);
        head2.next.next.next.next = new ListNode(10);

        ListNode result = sumLinkedLists(head1, head2);

        // Print the result: 7-9-11-13-15
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
