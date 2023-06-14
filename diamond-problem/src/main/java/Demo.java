public class Demo {

    public static void main(String[] args) {
        new SubClas().myMethod();
    }
}

interface Super {
    void myMethod();
}

interface A extends Super {
    @Override
    default void myMethod() {
        System.out.println("I am from Interface A");
    }
}

interface B extends Super {
    @Override
    default void myMethod() {
        System.out.println("I am from Interface B");
    }
}

class SubClas implements A, B{
    @Override
    public void myMethod() {
        System.out.println("I am from Sub Class");
    }
}
