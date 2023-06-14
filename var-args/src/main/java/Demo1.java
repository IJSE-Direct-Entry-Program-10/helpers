public class Demo1 {

    public static void main(String[] args) {
        print("ijse");
        print("ijse", "esoft");
        print();
        print("esoft", "sliit", "uom", "nsbm");
    }

    public static void print(String arg1, String arg2, String arg3, String arg4){
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
        System.out.println(arg4);
    }

    public static void print(){
        System.out.println();
    }

    public static void print(String arg){
        System.out.println(arg);
    }

    public static void print(String arg1, String arg2){
        System.out.println(arg1);
        System.out.println(arg2);
    }
}
