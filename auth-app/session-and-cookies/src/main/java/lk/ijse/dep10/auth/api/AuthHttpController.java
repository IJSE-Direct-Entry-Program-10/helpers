package lk.ijse.dep10.auth.api;

import lk.ijse.dep10.auth.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthHttpController {

    @Autowired
    private Connection connection;

    @PostMapping(value = "/signup", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Validated(UserDTO.SignUp.class) UserDTO userDTO) throws SQLException {
        PreparedStatement stmExistUser = connection.prepareStatement("SELECT username FROM user WHERE username = ?");
        stmExistUser.setString(1, userDTO.getUsername());
        if (stmExistUser.executeQuery().next()) throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        PreparedStatement stm = connection
                .prepareStatement("INSERT INTO user (username, password, full_name) VALUES (?, ?, ?)");
        stm.setString(1, userDTO.getUsername());
        stm.setString(2, userDTO.getPassword());
        stm.setString(3, userDTO.getFullName());
        stm.executeUpdate();
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public void login(@RequestBody @Valid UserDTO userDTO,
                      HttpServletRequest request) throws SQLException {
        PreparedStatement stm = connection
                .prepareStatement("SELECT * FROM user WHERE username = ? and password=?");
        stm.setString(1, userDTO.getUsername());
        stm.setString(2, userDTO.getPassword());
        ResultSet rst = stm.executeQuery();
        if (!rst.next()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access Denied");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", userDTO.getUsername());
            /*  This will create a new session for this user
             *   This will also set the set-cookie header with the SESSION ID
             * */
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    @GetMapping("/whoami")
    public String getUserDetails(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = session.getAttribute("username").toString();
            PreparedStatement stm = connection
                    .prepareStatement("SELECT full_name FROM user WHERE username = ?");
            stm.setString(1, username);
            ResultSet resultSet = stm.executeQuery();
            resultSet.next();
            return "Currently logged user: " + resultSet.getString("full_name");
        }
        return "Currently No Active User";
    }
}
