import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
        myGenericMethod1("Kasun");
        myGenericMethod1(10);
        myGenericMethod2("id", 1);
        myGenericMethod2("name", "Kasun");
        myGenericMethod2("address", "galle");
        myGenericMethod2("dob", LocalDate.now());

        DynamicArray<Integer> myArray = new DynamicArray<>();
        myArray.add(10);
        myArray.add(20);
        myArray.add(30);
        myArray.print();

        DynamicArray<String> myArray2 = new DynamicArray<>();
        myArray2.add("ijse");
        myArray2.add("esoft");
        myArray2.add("uom");
        myArray2.add("iit");
        myArray2.print();
    }

    public static <T> void myGenericMethod1(T t){
        System.out.println(t);
    }

    public static <K, V> void myGenericMethod2(K k, V v){
        System.out.printf("Key=%s, Value=%s \n", k, v);
    }
}

/*
* 1. Generic Types can't be instantiated (can't be used with the new keyword)
*           private T[] elements = new T[0];
*
* 2. Can't be used with primitive data types, only works with reference data types
*           private List<boolean> myList;
*           private List<Boolean> myList;
*
* 3. Can't be used with static variables
*           private static T something;
*
* 4. Can't create generic parametrized type arrays
*           private List<String>[] parameterizedTypeArray = new List<String>[0];
*
* 5. Parametrized types can't be used with casting or instance of operator
*           private ArrayList<Integer> intList = new ArrayList<Integer>();
*           private ArrayList<Number> numList = (ArrayList<Integer>) intList;
*           if (intList instanceOf ArrayList<Number>){}
*
* 6. Can't be used with catch, throw, or throws
*
* 7. Due to the Type Erasure Process some generic methods can raise conflicts at compile-time
*/
class DynamicArray<T> {
    private Object[] elements = new Object[0];

    public void add(T element){
        Object[] newElmArray = new Object[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newElmArray[i] = elements[i];
        }
        newElmArray[newElmArray.length - 1] = element;
        elements = newElmArray;
    }

    public void print(){
        System.out.println(Arrays.toString(elements));
    }
}
