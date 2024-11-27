import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetExample
  {
    public static void main(String[] args)
    {
      // hashset
      HashSet<String> hashSet = new HashSet<>();
      hashSet.add("apple");
      hashSet.add("banana");
      hashSet.add("orange");
      hashSet.add("apple");     // duplicate element; wont be added 

      // linked hash set
      LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
      linkedHashSet.add("apple");
      linkedHashSet.add("banana");
      linkedHashSet.add("orange");
      linkedHashSet.add("apple");     // duplicate, won't be added

      // TreeSet
      TreeSet<Integer> treeSet = new TreeSet<>();
      treeSet.add(10);
      treeSet.add(5);
      treeSet.add(15);
      treeSet.add(20);

      // iterating over sets
      for(String fruit : hashSet) {
        System.out.println(fruit);
      }
      for(String fruit : linkedHashSet) {
        System.out.println(fruit);
      }
      for(Integer number : treeSet) {
        System.out.println(number);
      }
    }
  }
