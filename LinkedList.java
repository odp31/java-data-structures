// linear data structure where elements are not stored in contiguous memory locations
// instead, each element, or node, contains a reference to the next node in the list

public class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class LinkedList {
  Node head;
  public LinkedList() {
    head = null;
  }
  // insert new node at beginning
  public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }
  // insert new node at end
  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    if(head == null) {
      head = newNode;
      return;
    }
    Node last = head;
    while(last.next != null) {
      last = last.next;
    }
    last.next = newNode;
  }
  // delete node by key
  public void deleteByKey(int key) {
    Node temp = head, prev = null;
    if(temp != null && temp.data == key) {
      head = temp.next;
      return;
    }
    while(temp != null && temp.data != key) {
      prev = temp;
      temp = temp.next;
    }
    if(temp == null)
      return;
    prev.next = temp.next;
  }
  // print linked list
  public void printList() {
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}
