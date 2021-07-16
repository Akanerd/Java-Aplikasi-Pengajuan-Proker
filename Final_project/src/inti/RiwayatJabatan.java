package inti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.table.DefaultTableModel;

//Deklarasi Atribut
public class RiwayatJabatan extends Jabatan {

    private String namaJabatan;

    private String statusJabatan;

    private String masaJabatan;

    public Jabatan jabatan;

    private String info[];

    //Deklarasi Constructor
    public RiwayatJabatan(String nidn) {
        //Inheritance mengambil Atribut nidn dari jabatan
        super(nidn);
        setStatusJabatan(this.statusJabatan);
        setMasaJabatan(this.masaJabatan);
        info = imp(nidn);
    }

    public RiwayatJabatan() {

    }
// OPerasi set-get

    public String getNamaJabatan() {
        return info[0];
    }

    public void setNamaJabatan(String newNamaJabatan) {
        namaJabatan = newNamaJabatan;
    }

    public String getStatusJabatan() {
        return info[1];
    }

    public void setStatusJabatan(String newStatusJabatan) {
        statusJabatan = newStatusJabatan;
    }

    public String getMasaJabatan() {
        return info[2];
    }

    public void setMasaJabatan(String newMasaJabatan) {
        masaJabatan = newMasaJabatan;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan newJabatan) {
        if (this.jabatan == null || !this.jabatan.equals(newJabatan)) {
            if (this.jabatan != null) {
                Jabatan oldJabatan = this.jabatan;
                this.jabatan = null;
                oldJabatan.removeRiwayatJabatan(this);
            }
            if (newJabatan != null) {
                this.jabatan = newJabatan;
                this.jabatan.addRiwayatJabatan(this);
            }
        }
    }
// operasi Method void dan Non-void 

    public String[] imp(String nidn) {
        String info[] = new String[3];
        try {
            Statement s = Koneksi.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `jabatan` WHERE nidn=" + nidn);
            while (rs.next()) {
                info[0] =  rs.getString("nama_jabatan");
                info[1] = rs.getString("STATUS_JABATAN");
                info[2] = rs.getString("MASA_JABATAN");
            }
            s.close();
        } catch (Exception i) {
            System.out.println(i);
        }

        return info;
    }

    public void getriwayat(DefaultTableModel tb) {
        try {
            String list[] = new String[10];
            String sql = "SELECT nama_jabatan_after,nama_jabatan_before,status_jabatan_after,status_jabatan_before,Periode_after,Periode_before,status_jabatan from `jabatan` join `riwayat_jabatan` on riwayat_jabatan.NIDN = jabatan.NIDN where nama_jabatan = '" + getNidn() + "'";
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            System.out.println(getNidn());
            while (rs.next()) {
                list[0] = rs.getString("nama_jabatan_after");
                list[1] = (rs.getString("nama_jabatan_before"));
                list[2] = (rs.getString("status_jabatan_after"));
                list[3] = (rs.getString("status_jabatan_before"));
                list[4] = (rs.getString("periode_after"));
                list[5] = (rs.getString("periode_before"));
                tb.addRow(list);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

// Operasi realasi set-get
    public void setproker(ArrayList<Proker> pr) {
        this.proker = pr;
    }

}
