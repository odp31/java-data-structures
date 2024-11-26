public class Heap<T extends Comparable<T>>
  {
    private T[] heap;
    private int size;
    private boolean isMinHeap;

    public Heap(int capacity, boolean isMinHeap)
    {
      heap = (T[]) new Comparable[capacity + 1];
      size = 0;
      this.isMinHeap = isMinHeap;
    }
    private int parent(int i)
    {
      return i / 2;
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
      while(i > 1 && compare(heap[i], heap[parent(i)]) < 0) {
        swap(i, parent(i));
        i = parent(i);
      }
    }
    private void heapifyDown(int i)
    {
      int smallest = i;
      int left = leftChild(i);
      int right = rightChild(i);

      if(left <= size && compare(heap[left], heap[smallest]) < 0) {
        smallest = left;
      }
      if(right <= size && compare(heap[right], heap[smallest]) < 0) {
        smallest = right;
      }
      if(smallest !- i) {
        swap(i, smallest);
        heapifyDown(smallest);
      }
    }
    private int compare(T a, T b)
    {
      if(isMinHeap) {
        return a.compareTo(b);
      }
      else{
        return b.compareTo(a);
      }
    }
    private void swap(int i, int j)
    {
      T temp = heap[i];
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
        throw new IllegalStateException("Heap is empty");
      }
      T root = heap[1];
      heap[1] = heap[size];
      size--;
      heapifyDown(1);
      return root;
    }
  }
