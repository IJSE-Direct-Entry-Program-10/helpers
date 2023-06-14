public class TypeErasure2 {

    public static void main(String[] args) {
//        print(new A1());
        print(new B1());
        print(new C1());
    }

    public static <T extends B1> void print(T t){
        t.print();
    }

    /* Compiled Output:
    * public static void print(B1 t){
    *   t.print();
    * }
    * */
}

class A1{
    void print(){}
}
class B1 extends A1{}
class C1 extends B1{}

