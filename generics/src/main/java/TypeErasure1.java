import java.util.Calendar;

public class TypeErasure1 {

    /* Erase of diamond Syntax <>  */

    public static void main(String[] args) {
        print("IJSE");
        print(10);
        print(true);
        print(Calendar.getInstance());
    }

    public static <T> void print(T t){
        System.out.println(t);
    }

    /* Compiled Output:
    * public static void print(Object t){
    *   System.out.println(t);
    * }
    * */
}
