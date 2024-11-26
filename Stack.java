public class Stack<T>
  {
    private Node<T> top;
    private int size;

    private static class Node<T>
      {
        T data;
        Node<T> next;

        public Node(T data)
        {
          this.data = data;
        }
      }
    public Stack() {
      top = null;
      size = 0;
    }
    public void push(T data)
    {
      Node<T> newNode = new Node<>(data);
      newNode.next = top;
      top = newNode;
      size++;
    }
    public T pop()
    {
      if(isEmpty()) {
        throw new IllegalStateException("stack is empty");
      }
      T data = top.data;
      top = top.next;
      size--;
      return data;
    }
    public T peek() {
      if(isEmpty()) {
        throw new IllegalStateException("stack is empty");
      }
      return top.data;
    }
    public boolean isEmpty()
    {
      return size == 0;
    }
    public int size()
    {
      return size;
    }
    public void printStack()
    {
      Node<T> current = top;
      while(current != null) {
        System.out.println(current.data + " ");
        current = current.next;
      }
      System.out.println();
    }
  }
