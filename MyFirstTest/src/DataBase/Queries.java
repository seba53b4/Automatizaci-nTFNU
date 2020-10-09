/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author seolivera
 */
public class Queries extends ConnectionManager{

    public Queries() {
    }
    
    
    
    
    public void agregarRecurso_MSISDN(List<String> numeros) throws SQLException{
        
        Statement st  = this.getConnection().createStatement();//prepro.prepareStatement("select * from nc_objects where OBJECT_ID = '9127005933813123419';");
        
        for (String numero : numeros) {
            String newLine = "INSERT INTO r_msisdn VALUES ('"+ numero +"' ,'"+numero.substring(0, 3)+"', null);";
            System.out.println("Insertado "+ "INSERT INTO students VALUES ('"+ numero +"' ,'"+numero.substring(0, 2)+"', null);");
            st.execute(newLine);
        }
        
        this.getConnection().commit();
        st.close();
    }
    
    public String selectRecurso_MSISDN() throws SQLException{
        
        Statement st  = this.getConnection().createStatement();//prepro.prepareStatement("select * from nc_objects where OBJECT_ID = '9127005933813123419';");
        ResultSet rs;
        String newLine = "select top 1 msisdn from r_msisdn where status is null;";
        
        System.out.println("Seleccion "+ "select top 1 msisdn from r_msisdn where status is null;");
        rs = st.executeQuery(newLine);
        String str = null;
        
        while ( rs.next() ) {
           str = rs.getString("msisdn");
        }
        newLine = "update r_msisdn set status = 'usado' where msisdn ="+str+";";
        st.execute(newLine);
        st.close();
        this.getConnection().commit();
        
        return str;
    }
    
    
    public void agregarRecuso_MSISDN(String numero){
         
        
        
    }
    
    public void agregarRecurso_ICCID (HashMap<String,List<String>> sims) throws SQLException{
        
        Statement st  = this.getConnection().createStatement();//prepro.prepareStatement("select * from nc_objects where OBJECT_ID = '9127005933813123419';");
        
        for (HashMap.Entry<String, List<String>>entry : sims.entrySet()) {
            
            for (String sim : entry.getValue()) {
                String newLine = "INSERT INTO r_iccid VALUES ('"+ sim +"' ,'"+entry.getKey()+"', null);";
                System.out.println("INSERT INTO r_iccid VALUES ('"+ sim +"' ,'"+entry.getKey()+"', null);");
                st.execute(newLine);
            }
            
        }
        
        this.getConnection().commit();
        st.close();
    }
    
     public String selectRecurso_ICCID(String rango) throws SQLException{
        
        Statement st  = this.getConnection().createStatement();//prepro.prepareStatement("select * from nc_objects where OBJECT_ID = '9127005933813123419';");
        ResultSet rs;
        String newLine = "select top 1 iccid from r_iccid where status is null and rango="+rango+";";
        
        System.out.println("Seleccion "+ "select top 1 iccid from r_iccid where status is null and rango="+rango+";");
        rs = st.executeQuery(newLine);
        String str = null;
        
        while ( rs.next() ) {
           str = rs.getString("iccid");
        }
        newLine = "update r_iccid set status = 'usado' where iccid ="+str+";";
        st.execute(newLine);
        st.close();
        this.getConnection().commit();
        
        return str;
    }
     public int countRecurso_ICCID(String rango) throws SQLException{
        
        Statement st  = this.getConnection().createStatement();//prepro.prepareStatement("select * from nc_objects where OBJECT_ID = '9127005933813123419';");
        ResultSet rs;
        String newLine = "select count(*) as cantidad from r_iccid where status is null and rango="+rango+";";
        
        System.out.println("Seleccion "+ "select count(*) as cantidad from r_iccid where status is null and rango="+rango+";");
        rs = st.executeQuery(newLine);
        String str = null;
        
        while ( rs.next() ) {
           str = rs.getString("cantidad");
        }
        
        st.close();
        
        return Integer.parseInt(str);
    }
     public int countRecurso_MSISDN(String rango) throws SQLException{
        
        Statement st  = this.getConnection().createStatement();//prepro.prepareStatement("select * from nc_objects where OBJECT_ID = '9127005933813123419';");
        ResultSet rs;
        String newLine = "select count(*) as cantidad from r_msisdn where status is null and rango="+rango+";";
        
        System.out.println("Seleccion "+ "select count(*) as cantidad from r_msisdn where status is null and rango="+rango+";");
        rs = st.executeQuery(newLine);
        String str = null;
        
        while ( rs.next() ) {
           str = rs.getString("cantidad");
        }
        st.close();
        
        return Integer.parseInt(str);
    }
     
     public void actualizarRecursos(String msisdn, String iccid,String usuario, String env, Date date) throws SQLException{
        
       Statement st  = this.getConnection().createStatement();//prepro.prepareStatement("select * from nc_objects where OBJECT_ID = '9127005933813123419';");
       
       
       String newLine = "INSERT INTO usados VALUES ('"+ msisdn +"' ,'"+iccid+"','"+usuario+"','"+env+"', '"+date+"');";
       System.out.println("Insertado "+ "INSERT INTO usados VALUES ('"+ msisdn +"' ,'"+iccid+"','"+usuario+"','"+env+"', '"+date+"');");
       st.execute(newLine);
       
       
        this.getConnection().commit();
        st.close();
        
    }
     
     
     
     
     
}
