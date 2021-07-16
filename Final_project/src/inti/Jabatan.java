package inti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Deklarasi Atribut
public class Jabatan {

    public String nidn;

    private String awaljabatan;

    private String akhirjabatan;
// Relasi 1.1 - 1.* ke Proker
    public java.util.Collection<RiwayatJabatan> riwayatJabatan;

    public java.util.Collection<Proker> proker;
// Relasi 1.1 - 1.1 dari Dosen ke jabatan 
    public Dosen dosen;

    private String info[];

// Deklarasi Constructor    
    public Jabatan(String nidn) {
        info = imp(nidn);
        setNidn(this.nidn);
        setawal(this.awaljabatan);
        setakhir(this.akhirjabatan);
    }

    public Jabatan() {

    }
//Operasi set-get
    public String getNidn() {
        return info[0];
    }
    

    public void setNidn(String newNidn) {
        nidn = newNidn;
    }

    public String getawal() {
        return info[1];
    }

    public void setawal(String newawal) {
        awaljabatan = newawal;
    }

    public String getakhir() {
        return info[2];
    }

    public void setakhir(String newakhir) {
        akhirjabatan = newakhir;
    }

    public java.util.Collection<RiwayatJabatan> getRiwayatJabatan() {
        if (riwayatJabatan == null) {
            riwayatJabatan = new java.util.ArrayList<RiwayatJabatan>();
        }
        return riwayatJabatan;
    }

    public java.util.Iterator getIteratorRiwayatJabatan() {
        if (riwayatJabatan == null) {
            riwayatJabatan = new java.util.ArrayList<RiwayatJabatan>();
        }
        return riwayatJabatan.iterator();
    }

    public void setRiwayatJabatan(java.util.Collection<RiwayatJabatan> newRiwayatJabatan) {
        removeAllRiwayatJabatan();
        for (java.util.Iterator iter = newRiwayatJabatan.iterator(); iter.hasNext();) {
            addRiwayatJabatan((RiwayatJabatan) iter.next());
        }
    }

    public void addRiwayatJabatan(RiwayatJabatan newRiwayatJabatan) {
        if (newRiwayatJabatan == null) {
            return;
        }
        if (this.riwayatJabatan == null) {
            this.riwayatJabatan = new java.util.ArrayList<RiwayatJabatan>();
        }
        if (!this.riwayatJabatan.contains(newRiwayatJabatan)) {
            this.riwayatJabatan.add(newRiwayatJabatan);
            newRiwayatJabatan.setJabatan(this);
        }
    }

    public void removeRiwayatJabatan(RiwayatJabatan oldRiwayatJabatan) {
        if (oldRiwayatJabatan == null) {
            return;
        }
        if (this.riwayatJabatan != null) {
            if (this.riwayatJabatan.contains(oldRiwayatJabatan)) {
                this.riwayatJabatan.remove(oldRiwayatJabatan);
                oldRiwayatJabatan.setJabatan((Jabatan) null);
            }
        }
    }

    public void removeAllRiwayatJabatan() {
        if (riwayatJabatan != null) {
            RiwayatJabatan oldRiwayatJabatan;
            for (java.util.Iterator iter = getIteratorRiwayatJabatan(); iter.hasNext();) {
                oldRiwayatJabatan = (RiwayatJabatan) iter.next();
                iter.remove();
                oldRiwayatJabatan.setJabatan((Jabatan) null);
            }
        }
    }

    public java.util.Collection<Proker> getProker() {
        if (proker == null) {
            proker = new java.util.HashSet<Proker>();
        }
        return proker;
    }

    public java.util.Iterator getIteratorProker() {
        if (proker == null) {
            proker = new java.util.HashSet<Proker>();
        }
        return proker.iterator();
    }

    public void setProker(java.util.Collection<Proker> newProker) {
        removeAllProker();
        for (java.util.Iterator iter = newProker.iterator(); iter.hasNext();) {
            addProker((Proker) iter.next());
        }
    }

    public void addProker(Proker newProker) {
        if (newProker == null) {
            return;
        }
        if (this.proker == null) {
            this.proker = new java.util.HashSet<Proker>();
        }
        if (!this.proker.contains(newProker)) {
            this.proker.add(newProker);
            newProker.setJabatan(this);
        }
    }

    public void removeProker(Proker oldProker) {
        if (oldProker == null) {
            return;
        }
        if (this.proker != null) {
            if (this.proker.contains(oldProker)) {
                this.proker.remove(oldProker);
                oldProker.setJabatan((Jabatan) null);
            }
        }
    }

    public void removeAllProker() {
        if (proker != null) {
            Proker oldProker;
            for (java.util.Iterator iter = getIteratorProker(); iter.hasNext();) {
                oldProker = (Proker) iter.next();
                iter.remove();
                oldProker.setJabatan((Jabatan) null);
            }
        }
    }
//operasi method Void dan Non-void
    public String[] imp(String nidn) {
        String info[] = new String[5];
        try {
            Statement s = Koneksi.getConnection().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `jabatan` WHERE nidn=" + nidn);
            while (rs.next()) {
                info[0] = rs.getString("nidn");
                info[1] = rs.getString("awal_JABATAN");
                info[2] = rs.getString("akhir_JABATAN");
            }
            s.close();
        } catch (Exception i) {
            System.out.println(i);
        }

        return info;
    }
     public void getproker() {
        try{
        String query = "SELECT id_proker,NAMA_DOSEN,DOSEN_PENANGGUNG,PERIODE_PROKER,REVISI_PROKER,URAIAN_PROKER,STATUS_WADEK,STATUS_DEKAN,ANGGARAN_DANA,TGLPERENCANAAN from dosen join proker on proker.ID_USER = dosen.ID_USER";
        PreparedStatement statement = Koneksi.getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            addProker(new Proker(rs.getString("id_proker"),
                    rs.getString("nama_dosen"), 
                    rs.getString("DOSEN_PENANGGUNG"), 
                    rs.getString("URAIAN_PROKER"), 
                    rs.getString("ANGGARAN_DANA"), 
                    rs.getString("TGLPERENCANAAN"), 
                    rs.getString("Revisi_proker"), 
                    rs.getString("status_dekan"), 
                    rs.getString("status_wadek"), 
                    rs.getString("periode_proker")));
            
        }

        statement.close();
        rs.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    // Relasi Set-get 
    public void setdosen(Dosen dsn) {
        this.dosen = dsn;
    }

    public Dosen getDosen() {
        return dosen;
    }

  
    public void setproker(ArrayList<Proker> pr) {
        this.proker = pr;
    }

    public void getproker(ArrayList<Proker> pr) {
        this.proker = pr;
    }
}
