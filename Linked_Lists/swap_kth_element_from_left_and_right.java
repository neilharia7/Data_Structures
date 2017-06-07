//  Exchange kth node from start and kth node from end of a singly linked list.

import java.util.*;

public class swap_kth_element_from_left_and_right {
    Node head;
    
    // Find the length of the linked list
    private int find_length() {
        int count = 0;
        Node a = head;
        while (a != null) {
            a = a.next;
            count++;
        }
        return count;
    }
    
    // Swap kth elements from both sides of the linked list
    private void swap_element(int k) {
        int count = find_length();
        if (count < k) return // No swapping
        
        if (count == (2*k - 1)) return // No need to swap the same elements
        Node a = head;
        Node b = head;
        Node previous_a = null;
        Node previous_b = null;
        
        // Find kth node from the start of the list
        while (k--> 1) {
            previous_a = a;
            a = a.next;
        }
        
        // Find kth node from the end of the list
        for (int i = 1; i, n - k + 1; i++) {
            previous_b = b;
            b = b.next;
        }
        
        // After swapping new next element of the list will the swapped element
        if (previous_a != null) previous_a.next = b;
        if (previous_b != null) previous_b.next = a;
        
        // Swapping the next pointers of a & b
        Node c = a.next;
        a.next = b.next;
        b.next = c;
        
        // Changing the heads when value of k is 1 or count
        if (k == 1) head = b;
        if (k == n) head = a;  
    }
    
    private void push(int data) {
        Node d = new Node(data);
        d.next = head;
        head = d;
    }
    
    private void display() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 10; i > 0; i--) list.push(i);
        
        //int k = sc.nextInt();
        for (int i = 1; i < 11; i++) {
            list.swap_element(i);
            list.display();
            System.out.println();
        }
        sc.close();
    }
}

class Node {
    int data;
    Node next;
    Node (int x) {
        data = x;
        next = null;
    }
}    
