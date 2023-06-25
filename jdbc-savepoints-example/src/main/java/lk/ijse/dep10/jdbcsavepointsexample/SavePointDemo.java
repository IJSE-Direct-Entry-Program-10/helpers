package lk.ijse.dep10.jdbcsavepointsexample;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.ExecutionException;

//@Component
public class SavePointDemo {

    private final DataSource dataSource;

    public SavePointDemo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void init() throws Exception {
        Connection connection = dataSource.getConnection();
        /* Let's start a transaction context */
        connection.setAutoCommit(false);
        try {
            update(connection, "INSERT INTO customer (name, address) VALUES (?,?)",
                    "Amila", "Colombo");

            /* Let's mark a point on the transaction */
            Savepoint savepoint = connection.setSavepoint();

            update(connection, "INSERT INTO customer (name, address) VALUES (?,?)",
                        "Upul", "Gampaha");
            connection.rollback(savepoint);

            /* Let's release the marked point on the transaction */
            connection.releaseSavepoint(savepoint);

            update(connection, "INSERT INTO customer (name, address) VALUES (?,?)",
                    "John", "Matara");

            connection.commit();
        } catch (Throwable t) {
            connection.rollback();
            System.out.println("Failed to execute the transaction");
        }
        connection.setAutoCommit(true);
    }

    private void update(Connection connection, String sql, Object... args) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            stm.setObject(i + 1, args[i]);
        }
        stm.execute();
    }
}
