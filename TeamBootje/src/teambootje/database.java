/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambBootje;
import java.sql.*;

/**
 *
 * @author kevin
 */
public class database {
    //check if con = null
    
    public Connection conn = null;
    
    public database(){
        // connection database
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/teambootje";
            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("conn build");
        } catch(SQLException e) {
           e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //SQLExeptions
    
    public ResultSet runSql(String sql) throws SQLException{
        Statement sta = conn.createStatement();
        return sta.executeQuery(sql);
    }
    
    public boolean runSql2(String sql) throws SQLException{
        Statement sta = conn.createStatement();
        return sta.execute(sql);
    }
    
    @Override
    protected void finalize() throws Throwable{
        if(conn != null || !conn.isClosed()){
            conn.close();
        }
    }
}

