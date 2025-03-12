package util;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Impossibile ottenere la connessione al database");
        }
    }
}
