package lk.ijse.dep10.jdbcsavepointsexample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /* DataSource Transaction Manager */
    @Transactional(readOnly = true)
    @GetMapping
    public void saveCustomer(){
        customerDAO.saveCustomer1(Customer.builder().name("Amila").address("Gampaha").build());
        customerDAO.saveCustomer2(Customer.builder().name("Ruwan").address("Polonnaruwa").build());
        throw new RuntimeException("Failed to save the customers");
    }
}

@Repository
class CustomerDAO {
    private final JdbcTemplate jdbcTemplate;

    CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveCustomer1(Customer customer) {
        jdbcTemplate.update("INSERT INTO customer (name, address) VALUES (?, ?)",
                customer.getName(), customer.getAddress());
    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveCustomer2(Customer customer) {
        jdbcTemplate.update("INSERT INTO customer (name, address) VALUES (?, ?)",
                customer.getName(), customer.getAddress());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Customer {
    private int id;
    private String name;
    private String address;
}