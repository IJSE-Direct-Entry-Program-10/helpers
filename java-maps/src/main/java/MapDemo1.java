import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapDemo1 {

    public static void main(String[] args) {
        Map<String, Integer> myLockers = new HashMap<>();
        myLockers.put("zzz", 100);
        myLockers.put("abc", 10);
        myLockers.put("edf", 20);
        myLockers.put("xyz", 30);
        myLockers.put("edf", 50);
        System.out.println(myLockers);
        System.out.println("-------------");
        System.out.println(myLockers.get("edf"));
        System.out.println(myLockers.containsKey("xyz"));
        myLockers.remove("xyz");
        System.out.println(myLockers.containsKey("xyz"));
    }
}
