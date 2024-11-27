import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample
  {
    public static void main(String[] args) {
      // create linkedhash map
      Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
      // add elements to map
      linkedHashMap.put("apple", 10);
      linkedHashMap.put("banana", 20);
      linkedHashMap.put("orange", 30);
      linkedHashMap.put("grape", 40);
      // iterate over map
      for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
        System.out.println(entry.getKey() + ": " + entry.getValue());
      }
    }
  }
