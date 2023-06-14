public class Demo4 {

    public static void main(String[] args) {
        DEP dep = new DEP();
        DEP10 dep10 = new DEP10();
        DEPSpecial depSpecial = new DEPSpecial();
//        doSomething(dep);
//        doSomething(dep10);
        doSomething(depSpecial);
    }

    public static <T extends DEP & IJSE & Institute> void doSomething(T t){
        t.print();
    }
}

class DEP{
    void print(){
        System.out.println("Working");
    }
}
class DEP10 extends DEP{}
interface IJSE{}
interface Institute{}

class DEPSpecial extends DEP implements IJSE, Institute{}