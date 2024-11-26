public class Queue<T>
  {
    private Node<T> front;
    private Node<T> rear;
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
    public Queue()
    {
      front = rear = null;
      size = 0;
    }
    public void enqueue(T data)
    {
      Node<T> newNode = new Node<>(data);
      if(isEmpty()) {
        front = rear = newNode;
      }
      else
      {
        rear.next = newNode;
        rear = newNode;
      }
      size++;
    }
    public T dequeue()
    {
      if(isEmpty()) {
        throw new IllegalStateException("queue is empty");
      }
      T data = front.data;
      front = front.next;
      if(front == null) {
        rear = null;
      }
      size--;
      return data;
    }
    public T peek() {
      if (isEmpty()) {
        throw new IllegalStateException("queue is empty");
      }
      return front.data;
    }
    public boolean isEmpty()
    {
      return size == 0;
    }
    public int size()
    {
      return size;
    }
    public void printQueue()
    {
      Node<T> current = front;
      while(current != null)
        {
          System.out.print(current.data + " ");
          curernt = current.next;
        }
      System.out.println();
    }
  }
