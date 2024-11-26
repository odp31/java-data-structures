import java.util.Comparator;

public class PriorityQueue<T>
  {
    private T[] heap;
    private int size;
    private final Comparator<T> comparator;

    public PriorityQueue(int capacity, Comparator<T> comparator)
    {
      heap = (T[]) new Object[capacity + 1];
      size = 0; 
      this.comparator = comparator;
    }
    private int parent(int i) 
    {
      return i /2;
    }
    private int leftChild(int i)
    {
      return 2 * i;
    }
    private int rightChild(int i)
    {
      return 2 * i + 1;
    }
    private void heapifyUp(int i)
    {
      while (i > 1 && comparator.compare(heap[i], heap[parent(i)]) < 0) {
        swap(i, parent(i));
        i = parent(i);
      }
    }
    private void heapifyDown(int i)
    {
      int smallest = i;
      int left = leftChild(i);
      int right = rightChild(i);

      if(left <= size && comparator.compare(heap[left], heap[smallest]) < 0) {
        smallest = left;
      }
      if(right <= size && comparator.compare(heap[right], heap[smallest]) < 0) {
        smallest = right;
      }
      if(smallest != i) {
        swap(i, smallest);
        heapifyDown(smallest);
      }
    }
    private void swap(int i, int j)
    {
      T temp = head[i];
      heap[i] = heap[j];
      heap[j] = temp;
    }
    public void insert(T data)
    {
      if(size == heap.length - 1) {
        throw new IndexOutOfBoundsException("heap is full");
      }
      size++;
      heap[size] = data;
      heapifyUp(size);
    }
    public T extractMin()
    {
      if(size == 0) {
        throw new IllegalStateException("heap is empty");
      }
      T root = heap[1];
      heap[1] = heap[size];
      size--;
      heapifyDown(1);
      return root;
    }
    public T peek()
    {
      if(size == 0) {
        throw new IllegalStateException("heap is empty");
      }
      return heap[1];
    }
    public boolean isEmpty()
    {
      return size == 0;
    }
    public int size()
    {
      return size;
    }
  }
