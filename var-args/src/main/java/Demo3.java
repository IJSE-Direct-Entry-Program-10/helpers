public class Demo3 {

    public static void main(String[] args) {
        print("ijse");          // print(new String[]{"ijse"});
        print("ijse", "esoft"); // print(new String[]{"ijse", "esoft"});
        print();                // print(new String[0]);
        print("esoft", "sliit", "uom", "nsbm");
    }

    /*
    *  1.5 - Generics, Var Args
    *  1.6 - Annotations
    *  1.7 - Try with Resource Statement
    *  1.8 - Lambdas, Method References
    *  1.9 - Module System, Private Methods in Interface
    * */

    //public static void print(String[] args)
    public static void print(String... args){
        if (args.length == 0) System.out.println();
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
