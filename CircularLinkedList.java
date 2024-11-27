// linear data structure where last node points back to first node, forming a circle loop 

class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class CircularLinkedList {
  Node head;
  public void insert(int data) {
    Node newNode = new Node(data);
    if(head == null) {
      head = newNode;
      newNode.next = head;
    }
    else{
      Node temp = head;
      while(temp.next != head) {
        temp = temp.next;
      }
      temp.next = newNode;
      newNode.next = head;
    }
  }
  public void deleteNode(int key) {
    if(head == null) {
      return;
    }
    Node temp = head;
    Node prev = null;

    if(head.data == key) {
      while(temp.next != head) {
        temp = temp.next;
      }
      temp.next = head.next;
      head = head.next;
      return;
    }
    while(temp.next != head && temp.data != key) {
      prev = temp;
      temp = temp.next;
    }
    if(temp.data == key) {
      prev.next = temp.next;
    }
  }
  public void printList() {
    if(head == null) {
      return;
    }
    Node temp = head;
    do {
      System.out.print(temp.data + " ");
      temp = temp.next;
    } while(temp!=head);
    System.out.println();
  }
}
