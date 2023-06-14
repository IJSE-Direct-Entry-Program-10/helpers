import java.util.ArrayList;

public class Demo3 {

    public static void main(String[] args) {
        DynamicArray<String> array1 = new DynamicArray<>();
        DynamicArray<Integer> array2 = new DynamicArray<>();
        print(array1);
        print(array2);

        DynamicArray<A> arrayA = new DynamicArray<>();
        DynamicArray<B> arrayB = new DynamicArray<>();
        DynamicArray<C> arrayC = new DynamicArray<>();
        DynamicArray<D> arrayD = new DynamicArray<>();

        print2(arrayB);
        print2(arrayC);
        print2(arrayD);

        print3(arrayA);
        print3(arrayB);
        print3(arrayC);
    }

    public static void print(DynamicArray<?> myArray) {
        myArray.print();
    }

    public static void print2(DynamicArray<? extends B> someArray){
        someArray.print();
    }

    public static void print3(DynamicArray<? super C> someArray){
        someArray.print();
    }
}

class A{}
class B extends A{}
class C extends B{}
class D extends C{}