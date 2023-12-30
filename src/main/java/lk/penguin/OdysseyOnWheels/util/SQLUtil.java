package lk.penguin.OdysseyOnWheels.util;

import lk.penguin.OdysseyOnWheels.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T>T execute(String sql,Object... arg) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement=DbConnection.getInstance().getConnection().prepareStatement(sql);

        for(int i=0;i<arg.length;i++){
            preparedStatement.setObject((i+1),arg[i]);
        }
        if(sql.trim().toUpperCase().startsWith("SELECT")){
            return (T)preparedStatement.executeQuery();
        }
        else{
            return (T)(Boolean)(preparedStatement.executeUpdate()>0);
        }
    }
}
