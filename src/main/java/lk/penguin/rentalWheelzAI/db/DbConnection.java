package lk.penguin.rentalWheelzAI.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cjxjc.Driver");

        connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/rental_wheelz",
                "penguinDB",
                "pax_penguina"
        );
    }
    public static DbConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbConnection==null){
            dbConnection=new DbConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
