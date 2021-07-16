package inti;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

//Deklarasi variabel Atribut
public class Dosen extends User {

    private String npp;

    private String namaDosen;

    private String ttlDosen;

    private String jkDosen;

    private String agamaDosen;

    private String alamatDosen;

    private String emailDosen;
//  realsi 1.1 - 1.1 ke jabatan    
    public Jabatan jabatan;
//  realsi 1.1 - 1.1 dari user ke Dosen
    public User user;

    private String pass;
 
    private String info[];

    //Deklarasi Constructor
    public Dosen(String npp) {
        setNpp(this.npp);
        setNamaDosen(this.namaDosen);
        setTtlDosen(this.ttlDosen);
        setJkDosen(this.jkDosen);
        setAgamaDosen(this.agamaDosen);
        setAlamatDosen(this.alamatDosen);
        setEmailDosen(this.emailDosen);
        info = imp(npp);
    }

    public Dosen() {

    }
    
    //Deklarasi Set - Get
    public String getNpp() {
        return info[0];
    }

    public void setNpp(String i) {
        npp = i;
    }

    public String getNamaDosen() {
        return info[1];
    }

    public void setNamaDosen(String i) {
        namaDosen = i;
    }

    public String getTtlDosen() {
        return info[2];
    }

    public void setTtlDosen(String i) {
        ttlDosen = i;
    }

    public String getJkDosen() {
        return info[3];
    }

    public void setJkDosen(String i) {
        jkDosen = i;
    }

    public String getAgamaDosen() {
        return info[4];
    }

    public void setAgamaDosen(String i) {
        agamaDosen = i;
    }

    public String getAlamatDosen() {
        return info[5];
    }

    public void setAlamatDosen(String i) {
        alamatDosen = i;
    }

    public String getEmailDosen() {
        return info[6];
    }

    public void setEmailDosen(String i) {
        emailDosen = i;
    }

    //Deklarasi Void dan Non-void
    public String[] imp(String npp) {
        String info[] = {"", "", "", "", "", "", "", ""};
        try {
            Statement s = Koneksi.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `dosen` WHERE npp=" + npp);
            while (rs.next()) {
                info[0] = rs.getString("npp");
                info[1] = rs.getString("nama_dosen");
                info[2] = rs.getString("ttl_dosen");
                info[3] = rs.getString("jk_dosen");
                info[4] = rs.getString("agama_dosen");
                info[5] = rs.getString("alamat_dosen");
                info[6] = rs.getString("email_dosen");

            }
            s.close();
        } catch (Exception i) {
            System.out.println(i);
        }

        return info;
    }    

    public void update() throws Exception {

        try {
            Statement s = Koneksi.getConnection().createStatement();
            s.execute("update dosen set `AGAMA_DOSEN`='"+agamaDosen+"', `ALAMAT_DOSEN`= '"+alamatDosen+"',`EMAIL_DOSEN`='"+emailDosen+"' where `NPP` = '"+npp+"'");
            s.close();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil!");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
    
    //relasi set-get
    public void setuser(User usr) {
        this.user = usr;
    }

    public User getUser() {
        return user;
    }

    public void setjabatan(Jabatan jbtn) {
        this.jabatan = jbtn;
    }

    public Jabatan getjabatan() {
        return jabatan;
    }
}
