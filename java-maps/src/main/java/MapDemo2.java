import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo2 {

    public static void main(String[] args) {
        Map<String, Integer> myLockers = new LinkedHashMap<>();
        myLockers.put("zzz", 100);
        myLockers.put("abc", 10);
        myLockers.put("edf", 20);
        myLockers.put("xyz", 30);
        myLockers.putIfAbsent("edf", 50);
        System.out.println(myLockers);
        System.out.println("-------------");
        System.out.println(myLockers.get("edf"));
        System.out.println(myLockers.containsKey("xyz"));
        myLockers.remove("xyz");
        System.out.println(myLockers.containsKey("xyz"));
    }
}
