import java.util.stream.Stream;

public class TypeErasure3 {

    public static void main(String[] args) {
        new CustomerDAO().saveCustomer(new Customer(1, "Kasun", "Galle"));
    }
}

interface CrudDAO<T>{
    void saveCustomer(T entity);
}

/* Compiled Output:
interface CrudDAO{
    void saveCustomer(Object entity);
}
class CustomerDAO implements CrudDAO{
    void saveCustomer(Object entity){           // <- Bridge Method
        saveCustomer((Customer) entity);        // <- Automatic Casting
    }
    @Override
    public void saveCustomer(Customer entity) {
    }
}
*/

class CustomerDAO implements CrudDAO<Customer>{

    @Override
    public void saveCustomer(Customer entity) {
        Stream.of(Thread.currentThread().getStackTrace()).forEach(System.out::println);
        System.out.println("IJSE");
    }
}

class Customer {
    int id;
    String name;
    String address;

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
