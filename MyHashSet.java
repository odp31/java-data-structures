import java.util.Arraylist;
import java.util.LinkedList;

public class MyHashSet<T>
  {
    private static class Entry<T>
      {
        T key;
        public Entry(T key) 
        {
          this.key = key;
        }
      }
    private ArrayList<LinkedList<Entry<T>>> table;
    private int capacity;
    private int size;

    public MyHashSet(int capacity)
    {
      this.capacity = capacity;
      table = new Arraylist<>(capacity);
      for(int i = 0; i < capacity; i++) {
        table.add(new LinkedList<>());
      }
    }
    private int hash(T key)
    {
      return key.hashCode() % capacity;
    }
    public void add(T key)
    {
      int index = hash(key);
      LinkedList<Entry<T>> list = table.get(index);

      for(Entry<T> entry: list) {
        if(entry.key.equals(key)) {
          return;
        }
      }
      list.add(new Entry<>(key));
      size++;
    }
    public boolean contains(T key)
    {
      int index = hash(key);
      LinkedList<Entry<T>> list = table.get(index);
      for(Entry<T> entry: list) {
        if(entry.key.equals(key)) {
          return true;
        }
      }
      return false;
    }
    public void remove(T key)
    {
      int index = hash(key);
      LinkedList<Entry<T>> list = table.get(index);
      for(Entry<T> entry : list)
        {
          if(entry.key.equals(key)) {
            list.remove(entry);
            size--;
            return;
          }
        }
    }
    public int size()
    {
      return size;
    }
    public boolean isEmpty()
    {
      return size == 0;
    }
  }
