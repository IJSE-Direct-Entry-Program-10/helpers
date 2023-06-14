import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo3 {

    public static void main(String[] args) {
        
        /* Red-Black Binary Tree */
        SortedMap<String, Integer> marks = new TreeMap<>();

        marks.put("Kasun", 80);
        marks.put("Nuwan", 80);
        marks.put("Supun", 70);
        marks.put("Ruwan", 85);
//        marks.put(null, 85);      /* We can't use null as a key */
        marks.put("Achini", 65);

        System.out.println(marks);
    }
}
