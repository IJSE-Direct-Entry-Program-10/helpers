import java.util.Calendar;

public class Demo1 {

    public static void main(String[] args) {
        Demo1.<String>myMethod("ijse");
        var x = 10;
        myMethod("esoft");
        Demo1.<String>myMethod("sliit");
        Demo1.<String>myMethod("uom");
        Demo1.<String>myMethod("iit");
        Demo1.<Integer>myMethod(10);
        Demo1.<Boolean>myMethod(false);
        Demo1.<Calendar>myMethod(Calendar.getInstance());
        Demo1.<Double>myMethod(10.25);

        doSomething(50);
    }

    public static void doSomething(int x){
        int y = x;
        int z = x;
        int result = y + z;
        System.out.println(x+ result);
    }

    public static <T> void myMethod(T something){
        T abc = something;
        System.out.println(abc);
    }
}
