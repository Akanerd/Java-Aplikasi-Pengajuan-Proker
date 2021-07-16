package inti;

import gui.login;
import gui.menu_dekan;
import gui.menu_kaprodi;
import gui.menu_wadek;
import java.sql.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Deklarasi Variabel atribut
public class User {

    private int iduser;
 
    private String username;

    private String password;
//Relasi 1.1 - 1.1
    public Dosen dosen;

// Deklarasi Constructor     
    public User() {
       setUsername(this.username);
       setPassword(this.password);

    }

// Operasi Set - Get
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int newIduser) {
        iduser = newIduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    //Operasi Method Non-void dan void
    public String login() throws Exception {
        String pass = null;
        try {

            int year = Calendar.getInstance().get(Calendar.YEAR);
            Statement s = Koneksi.getConnection().createStatement();
            ResultSet rs = s.executeQuery("select user.USERNAME,user.PASSWORD,user.akses,jabatan.awal_jabatan,jabatan.akhir_jabatan from `user` JOIN `jabatan` ON jabatan.ID_USER = user.ID_USER WHERE user.USERNAME = '"+username+"' and PASSWORD = '"+password+"'");
            if (rs.next()) {
                if(rs.getInt("akses")==1&&rs.getInt("awal_jabatan")==year ){
                if ("kaprodi".equals(rs.getString("username")) && ("kaprodi".equals(rs.getString("password")))) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + rs.getString("username"));
                    lastlogin();
                    menu_kaprodi kaprodi = new menu_kaprodi();
                    kaprodi.show();

                } else if ("wadek".equals(rs.getString("username")) && ("wadek".equals(rs.getString("password")))) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + rs.getString("username"));
                    lastlogin();
                    menu_wadek wadek = new menu_wadek();
                    wadek.show();
                } else if ("dekan".equals(rs.getString("username")) && ("dekan".equals(rs.getString("password")))) {
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + rs.getString("username"));
                    lastlogin();
                    menu_dekan dekan = new menu_dekan();
                    dekan.show();
                }
                }
                else if(rs.getInt("akhir_jabatan")==year){
                       JOptionPane.showMessageDialog(null, "Maaf Akun terblokir atau akun anda telah habis masanya silahkan menghubungi admin");
                       login lgn = new login();
                       lgn.show();
                }
                else{
                      JOptionPane.showMessageDialog(null, "Maaf Akun terblokir atau akun anda telah habis masanya silahkan menghubungi admin");
                       login lgn = new login();
                       lgn.show();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mohon Hubungi ADMIN Akun anda tidak tersedia");
                login lgn = new login();
                lgn.show();
            }
        } catch (Exception i) {
            System.out.println(i);
        }
        return pass;
    }
     public void lastlogin() throws Exception {
         try {
            Statement s = Koneksi.getConnection().createStatement();
            s.execute("update user set lastlogin = CURRENT_TIMESTAMP WHERE username = '"+getUsername()+"' and password = '"+getPassword()+"'");
            s.close();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

     //Relasi set-get
    public void setdosen(Dosen dsn) {
        this.dosen = dsn;
    }

    public Dosen getDosen() {
        return dosen;
    }

}
