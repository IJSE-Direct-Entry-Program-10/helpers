package lk.ijse.dep10.auth.api;

import lk.ijse.dep10.auth.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerHttpController {

    @Autowired
    private Connection connection;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() throws SQLException {
        List<CustomerDTO> customerList = new ArrayList<>();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM customer");
        ResultSet rst = stm.executeQuery();
        while (rst.next()) {
            CustomerDTO customer = CustomerDTO.builder().id(rst.getInt("id")).name(rst.getString("name")).address(rst.getString("address")).build();
            customerList.add(customer);
        }
        return customerList;
    }
}
