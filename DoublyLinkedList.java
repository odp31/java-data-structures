public class DoublyLinkedList<T>
  {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T>
      {
        T data;
        Node<T> prev;
        Node<T> next;
        public Node(T data)
        {
          this.data = data;
        }
      }
    public DoublyLinkedList()
    {
      head = null;
      tail = null;
      size = 0;
    }
    public void addFirst(T data)
    {
      Node<T> newNode = new Node<>(data);
      if(head == null) {
        head = tail = newNode;
      }
      else {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
      }
      size++;
    }
    public void addLast(T data)
    {
      Node<T> newNode = new Node<>(data);
      if(tail == null) {
        head = tail = newNode;
      }
      else
      {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
      }
      size++;
    }
    public void addAtIndex(int index, T data)
    {
      if(index < 0 || index > size) {
        throw new IndexOutOfBoundsException();
      }
      if(index == 0) {
        addFirst(data);
      }
      else if(index == size) {
        addLast(data);
      }
      else
      {
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for(int i = 0; i < index - 1; i++) {
          current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
      }
    }
    public T removeFirst()
    {
      if(head == null) {
        throw new IllegalStateException("list is empty");
      }
      T data = head.data;
      head = head.next;
      if(head != null) {
        head.prev = null;
      }
      else{
        tail = null;
      }
      size--;
      return data;
    }
    public T removeLast()
    {
      if(tail == null) {
        throw New IllegalStateException("list is empty");
      }
      T data = tail.data;
      tail = tail.prev;
      if(tail != null)
      {
        tail.next = null;
      }
      else
      {
        head = null;
      }
      size--;
      return data;
    }
  }
