package lk.penguin.OdysseyOnWheels.util;

import lk.penguin.OdysseyOnWheels.db.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtil {

    public static Connection connection;

    static {
        try {
            connection = DbConnection.getInstance().getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public TransactionUtil() throws SQLException,ClassNotFoundException{

    }

    public static void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }
    public static void endTransaction() throws SQLException {
        connection.setAutoCommit(true);
    }
    public static void rollBack() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }
}
