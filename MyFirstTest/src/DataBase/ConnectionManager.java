/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
/**
 *
 * @author seolivera
 */
public class ConnectionManager {
    
    private String database;
    
    //private Connection connection;
    //private HashMap<String,Connection> conexiones;
    private static ConnectionManager conDB;
    private Connection conn;
    
    public ConnectionManager(){
        /*/conexiones = new HashMap<>();
        conexiones.put("JIT", null);
        conexiones.put("E2E", null);
        conexiones.put("UAT", null);
        conexiones.put("PreProd", null);
        conexiones.put("TEST", null);
        conexiones.put("PLM1", null);
        conexiones.put("PLM2", null);*/
        this.conn = conexion();
    }
    
    public Connection getConnection(){
        
        return conn;
    }
    
    
    public static ConnectionManager initConnection()
    {
        if (conDB == null) {
            conDB = new ConnectionManager();
        }
        return conDB;
    }
    
    public void closeConnection()
    {
        try{
            conn.close();
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void commit()
    {
        try{
            conn.commit();
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public Connection conexion(){
        /*
        switch (nameDB) {
            case "JIT":
                database = "jdbc:oracle:thin:@10.24.135.10:1521:NJITTOMS";
                break;
            case "E2E":
                database = "jdbc:oracle:thin:@10.24.135.10:1521:NE2ETOMS";
                break;
            case "UAT":
                database = "jdbc:oracle:thin:@10.24.135.10:1521:NUATTOMS";
                break;
            case "PreProd":
                database = "jdbc:oracle:thin:@//10.24.35.77:1523/prdtoms_srv";
                break;
            case "TEST":
                database = "jdbc:oracle:thin:@10.24.135.10:1521:NTSTTOMS";
                break;
            case "PLM1":
                database = "jdbc:oracle:thin:@10.24.135.10:1521:NPLMTOMS";
                break;
            case "PLM2":
                database = "jdbc:oracle:thin:@10.24.135.10:1521:NPLM2TOM";
                break;            
            default:
                throw new AssertionError();
        }        */
            
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            database = "jdbc:sqlserver://10.24.156.149:1433;databaseName=SQA_Auto_Tool;integratedSecurity=false;";
            // "jdbc:sqlserver://localhost\\sqlexpress;user=sa;password=secret"
            String user = "app_sqatool";
            String password = "4Pp_zK4t00L";
            java.sql.Connection conn = DriverManager.getConnection(database,user,password);
            System.out.println("paso por aca");
           /* if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            } else {
                System.out.println("Conexion nula");
            }*/
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
           
        }
        return null;
        
    }
    
}
