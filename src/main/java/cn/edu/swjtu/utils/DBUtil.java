package cn.edu.swjtu.utils;

import java.sql.*;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/swjtu?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private String username = "root";

    private String userpwd = "1120.ypzpoi";

    private Statement statement;

    public void initializeDB(){
        try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,username,userpwd);
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean executeQuery(String username,String userpwd){
        if (username==null||userpwd==null){
            return false;
        }
        String sql = "select * from users where username='"+username+"' and userpwd='"+
                userpwd+"'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
