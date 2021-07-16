package inti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

//Operasi Method untuk Koneksi Ke Database
public class Koneksi {
    private static Connection connection = null;
    
    public static Connection getConnection() throws Exception{
        if (connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/programkerja","root","");
            } catch (Exception e) {
                System.out.println("error di sini juga");
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }
    
    public static boolean isConnect(){
        try {
            if (getConnection()==null){
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
