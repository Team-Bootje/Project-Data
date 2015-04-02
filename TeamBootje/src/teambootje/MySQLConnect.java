/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;

import java.util.logging.Logger;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author kevin
 */
public class MySQLConnect {
    private static final Logger LOG = Logger.getLogger(MySQLConnect.class.getName());
    Connection conn = null;
    
    public static Connection ConectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teambootje", "root", "");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
