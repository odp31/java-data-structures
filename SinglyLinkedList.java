public class SinglyLinkedList<T>
  {
    private Node<T> head;

    private static class Node<T>
      {
        T data;
        Node<T> next;

        public Node(T data) {
          this.data = data;
          this.next = null;
        }
      }
    public void add(T data)
    {
      Node<T> newNode = new Node<>(data);
      if(head == null) {
        head = newNode;
      }
      else{
        Node<T> current = head;
        while(current.next != null) {
          current = current.next;
        }
        current.next = newNode;
      }
    }
    public void printList()
    {
      Node<T> current = head;
      while(current != null)
        {
          System.out.print(current.data + " ");
          current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
      SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
      list.add(10);
      list.add(20);
      list.add(30);
      list.printList();
    }
  }
