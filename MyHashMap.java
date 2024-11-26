import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap<K, V>
  {
    private static class Entry<K, V> {
      K key;
      V value;
      public Entry(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int capacity;
    private int size;

    public MyHashMap(int capacity)
    {
      this.capacity = capacity; 
      table = new ArrayList<>(capacity);
      for(int i = 0; i < capacity; i++) {
        table.add(new LinkedList<>());
      }
    }
    private int hash(K key) {
      return key.hashCode() % capacity; 
    }
    public void put(K key, V value)
    {
      int index = hash(key);
      LinkedList<Entry<K, V>> list = table.get(index);

      for(Entry<K, V> entry : list) {
        if(entry.key.equals(key)) {
          entry.value = value;
          return;
        }
      }
      list.add(new Entry<>(key, value));
      size++;
    }
    public V get(K key)
    {
      int index = hash(key);
      LinkedList<Entry<K, V>> list = table.get(index);
      for(Entry<K, V> entry : list)
        {
          if(entry.key.equals(key)) {
            return entry.value;
          }
        }
      return null;
    }
    public void remove(K key)
    {
      int index = hash(key);
      LinkedList<Entry<K, v>> list = table.get(index);
      for(Entry<K, V> entry : list) {
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
