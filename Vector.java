// dynamic array that can grow or shrink as needed; can store elements of any
// data type 

import java.util.Arrays;

public class Vector<E>
  {
    private Object[] elements;
    private int size;
    private static final in DEFAUL_CAPACITY = 10;

    // constructor
    public Vector() {
      elements = new Object[DEFAULT_CAPACITY];
      size = 0;
    }
    // adds element to end of vector
    public void add(E element)
    {
      ensureCapacity(size + 1);
      elements[size++] = element;
    }
    // gets element at index
    public E get(int index) {
      if(index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("index out of bounds");
      }
      return (E) elements[index];
    }
    // sets element at index
    public void set(int index, E element) 
    {
      if(index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("index out of bounds");
      }
      elements[index] = element;
    }
    // removes element at index
    public void remove(int index) {
      if(index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("index out of bounds");
      }
      System.arraycopy(elements, index + 1, elements, index, size - index - 1);
      size--;
    }
    // returns size
    public int size()
    {
      return size;
    }
    // checks if vector is empty
    public boolean isEmpty()
    {
      return size == 0;
    }
    // ensures the capacity of vector is at least min capacity
    private void ensureCapacity(int minCapacity)
    {
      if(minCapacity > elements.length) {
        int newCapacity = Math.max(minCapacity, elements.length * 2);
        elements = Arrays.copyOf(elements, newCapacity);
      }
    }
  }
