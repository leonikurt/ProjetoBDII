/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casa
 */
public class ConexaoDB {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test_bd2";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConexaoDB(){
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao!");
        }
    }
    
    public static void closeConexaoDB(Connection con){
        
            try {
                if(con != null)
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

