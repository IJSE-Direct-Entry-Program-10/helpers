import java.util.stream.Stream;

public class Demo2 {

    public static void main(String[] args) {
        print(new String[]{"ijse"});
        print(new String[]{"ijse", "esoft"});
        print(new String[]{""});
        print(new String[]{"esoft", "sliit", "uom", "nsbm"});
    }

    public static void print(String[] args){
        if (args == null) return;
        Stream.of(args).forEach(System.out::println);
//        for (String arg : args) {
//            System.out.println(args);
//        }
    }
}
