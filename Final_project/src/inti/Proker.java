package inti;

import gui.menuprokerdekan;
import gui.menuprokerkaprodi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


//Deklarasi Atribut
public class Proker {

    private String idproker;

    private String dosenPenanggung;

    private String uraianProker;

    private String anggaranDana;

    private String tglperencanaan;

    private String revisiProker;

    private String status_dekan;

    private String status_wadek;

    private String periodeProker;

    public Jabatan jabatan;
    
    public Dosen Dosen;

    private String dosen;

    private String info[];

    //Deklarasi Constructor
    public Proker(String idproker,String dosen, String dosenPenanggung, String uraianProker, String anggaranDana, String tglperencanaan, String revisiProker, String status_dekan, String status_wadek, String periodeProker) {
        //this.idproker = idproker;
        setIdproker(idproker);
        setDosenPenanggung(dosenPenanggung);
        setUraianProker(uraianProker);
        setTglperencanaan(tglperencanaan);
        setAnggaranDana(anggaranDana);
        setRevisiProker(revisiProker);
        setStatusdekan(status_dekan);
        setStatusWadek(status_wadek);
        setPeriodeProker(periodeProker);
        setdosen(dosen);

    }

    public Proker() {

    }
// Operasi set-get

    public String getIdproker() {
        return idproker;
    }

    public void setIdproker(String newIdproker) {
        idproker = newIdproker;
    }

    public String getdosen() {
        return dosen;
    }

    public void setdosen(String newdosen) {
        dosen = newdosen;
    }

    public String getDosenPenanggung() {
        return dosenPenanggung;
    }

    public void setDosenPenanggung(String newDosenPenanggung) {
        dosenPenanggung = newDosenPenanggung;
    }

    public String getUraianProker() {
        return uraianProker;
    }

    public void setUraianProker(String newUraianProker) {
        uraianProker = newUraianProker;
    }

    public String getStatusWadek() {
        return status_wadek;
    }

    public void setStatusWadek(String newStatusProker) {
        status_wadek = newStatusProker;
    }

    public String getStatusdekan() {
        return status_dekan;
    }

    public void setStatusdekan(String newStatusProker) {
        status_dekan = newStatusProker;
    }

    public String getAnggaranDana() {
        return anggaranDana;
    }

    public void setAnggaranDana(String newAnggaranDana) {
        anggaranDana = newAnggaranDana;
    }

    public String getTglperencanaan() {
        return tglperencanaan;
    }

    public void setTglperencanaan(String newTglperencanaan) {
        tglperencanaan = newTglperencanaan;
    }

    public String getRevisiProker() {
        return revisiProker;
    }

    public void setRevisiProker(String newRevisiProker) {
        revisiProker = newRevisiProker;
    }

    public String getPeriodeProker() {
        return periodeProker;
    }

    public void setPeriodeProker(String newPeriodeProker) {
        periodeProker = newPeriodeProker;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan newJabatan) {
        if (this.jabatan == null || !this.jabatan.equals(newJabatan)) {
            if (this.jabatan != null) {
                Jabatan oldJabatan = this.jabatan;
                this.jabatan = null;
                oldJabatan.removeProker(this);
            }
            if (newJabatan != null) {
                this.jabatan = newJabatan;
                this.jabatan.addProker(this);
            }
        }
    }
//

    public void insert() throws Exception {
        try {
            Statement s = Koneksi.getConnection().createStatement();
            s.executeUpdate("INSERT INTO `proker`(`id_proker`,`DOSEN_PENANGGUNG`, `URAIAN_PROKER`, `periode_proker`, `ANGGARAN_DANA`, `TGLPERENCANAAN`) "
                    + "VALUES (\"" + getIdproker() + "\",\"" + getDosenPenanggung() + "\",\"" + getUraianProker() + "\",\"" + getPeriodeProker() + "\",\"" + getAnggaranDana() + "\",\"" + getTglperencanaan() + "\")");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diinputkan");
            s.close();
        } catch (Exception i) {
            JOptionPane.showMessageDialog(null, "Data Proker telah ada");
        }
    }

    public void updatekaprodi() throws Exception {
        try {
            Statement s = Koneksi.getConnection().createStatement();
            s.executeUpdate("UPDATE `proker` SET `DOSEN_PENANGGUNG`='" + getDosenPenanggung() + "',`URAIAN_PROKER`='" + getUraianProker() + "',`periode_proker`='" + getPeriodeProker() + "',`ANGGARAN_DANA`= '" + getAnggaranDana() + "',`TGLPERENCANAAN`= '" + getTglperencanaan() + "' WHERE ID_PROKER ='" + getIdproker() + "'");
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
            s.close();
        } catch (Exception i) {
            System.out.println(i);
        }
    }

    public void updatewadek() throws Exception {
        try {
            Statement s = Koneksi.getConnection().createStatement();
            s.executeUpdate("UPDATE `proker` SET `revisi_proker`='" + getRevisiProker() + "',`STATUS_WADEK`='" + getStatusWadek() + "' WHERE ID_PROKER ='" + getIdproker() + "'");
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
            s.close();
        } catch (Exception i) {
            System.out.println(i);
        }
    }

    public void updatedekan() throws Exception {
        try {
            Statement s = Koneksi.getConnection().createStatement();
            s.executeUpdate("UPDATE `proker` SET `STATUS_dekan`='" + getStatusdekan() + "' WHERE ID_PROKER ='" + getIdproker() + "'");
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
            s.close();
        } catch (Exception i) {
            System.out.println(i);
        }
    }

    public void delete() throws Exception {
        try {
            Statement s = Koneksi.getConnection().createStatement();
            s.executeUpdate("DELETE FROM `proker` WHERE ID_PROKER ='" + getIdproker() + "'");
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            s.close();
        } catch (Exception i) {
            System.out.println(i);
        }
    }

    public ArrayList viewAll() throws Exception {
        ArrayList list = new ArrayList<>();
        String query = "SELECT id_proker,NAMA_DOSEN,DOSEN_PENANGGUNG,PERIODE_PROKER,REVISI_PROKER,URAIAN_PROKER,STATUS_WADEK,STATUS_DEKAN,ANGGARAN_DANA,TGLPERENCANAAN from dosen join proker on proker.ID_USER = dosen.ID_USER ";
        PreparedStatement statement = Koneksi.getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Proker p = new Proker();
            p.setdosen(rs.getString("Nama_dosen"));
            p.setIdproker(rs.getString("id_proker"));
            p.setDosenPenanggung(rs.getString("DOSEN_PENANGGUNG"));
            p.setUraianProker(rs.getString("URAIAN_PROKER"));
            p.setPeriodeProker(rs.getString("periode_proker"));
            p.setRevisiProker(rs.getString("Revisi_proker"));
            p.setStatusWadek(rs.getString("status_wadek"));
            p.setStatusdekan(rs.getString("status_dekan"));
            p.setAnggaranDana(rs.getString("ANGGARAN_DANA"));
            p.setTglperencanaan(rs.getString("TGLPERENCANAAN"));
            list.add(p);
        }

        statement.close();
        rs.close();
        return list;
    }

    public void getRwtproker(DefaultTableModel tb) {
        try {
            String sql = "SELECT  `Dosen_penanggung`, `Uraian_proker`, `Periode_proker`, `Revisi_after`, `Revisi_before`,"
                    + " `Status_wadek_after`, `Status_wadek_before`, `Status_dekan_after`, `Status_dekan_before`, `Anggaran_dana`, `Tgl_perencanaan` FROM `riwayat_proker` ";
            PreparedStatement statement = Koneksi.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String row[] = {rs.getString("Dosen_penanggung"), rs.getString("Uraian_proker"), rs.getString("Periode_proker"), rs.getString("Revisi_after"), rs.getString("Revisi_before"),
                    rs.getString("Status_wadek_after"), rs.getString("Status_wadek_before"), rs.getString("Status_dekan_after"), rs.getString("Status_dekan_before"), rs.getString("anggaran_dana"), rs.getString("Tgl_perencanaan")};
                tb.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewAllfilter(DefaultTableModel tb, String periode) throws Exception {
        String[] list = new String[10];
        String query = "SELECT `ID_PROKER`, `DOSEN_PENANGGUNG`, `URAIAN_PROKER`, `periode_proker`, `Revisi_proker`, `STATUS_DEKAN`,`STATUS_WADEK`, `ANGGARAN_DANA`, `TGLPERENCANAAN` FROM `proker` WHERE periode_proker = '" + periode + "'";
        PreparedStatement statement = Koneksi.getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            list[0] = rs.getString("id_proker");
            list[1] = (rs.getString("DOSEN_PENANGGUNG"));
            list[2] = (rs.getString("URAIAN_PROKER"));
            list[3] = (rs.getString("periode_proker"));
            list[4] = (rs.getString("Revisi_proker"));
            list[5] = (rs.getString("STATUS_WADEK"));
            list[6] = (rs.getString("STATUS_DEKAN"));
            list[7] = (rs.getString("ANGGARAN_DANA"));
            list[8] = (rs.getString("TGLPERENCANAAN"));
            tb.addRow(list);
        }

        statement.close();
        rs.close();

    }

    public void viewAllfilterkaprodi(DefaultTableModel tb, String periode) throws Exception {
        String[] list = new String[10];
        String query = "SELECT id_proker,NAMA_DOSEN,DOSEN_PENANGGUNG,PERIODE_PROKER,REVISI_PROKER,URAIAN_PROKER,STATUS_WADEK,STATUS_DEKAN,ANGGARAN_DANA,TGLPERENCANAAN from dosen join proker on proker.ID_USER = dosen.ID_USER WHERE periode_proker = '" + periode + "'";
        PreparedStatement statement = Koneksi.getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            list[0] = rs.getString("Nama_dosen");
            list[1] = rs.getString("id_proker");
            list[2] = (rs.getString("DOSEN_PENANGGUNG"));
            list[3] = (rs.getString("URAIAN_PROKER"));
            list[4] = (rs.getString("periode_proker"));
            list[5] = (rs.getString("ANGGARAN_DANA"));
            list[6] = (rs.getString("TGLPERENCANAAN"));
            tb.addRow(list);
        }

        statement.close();
        rs.close();

    }

    public String autoid() {
        int i = 0;
        try {
            Statement state = Koneksi.getConnection().createStatement();
            String query = "SELECT * FROM proker";
            ResultSet rs = state.executeQuery(query);
            while (rs.next()) {
                i = rs.getRow();
            }
            rs.close();
            state.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return String.valueOf(i + 1);
    }

    public void export() throws Exception {
        try {
            Statement s = Koneksi.getConnection().createStatement();
            FileOutputStream fileOut;
            // Hasil Export
            fileOut = new FileOutputStream("D:/export.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");

            // Nama Field
            Row row1 = worksheet.createRow((short) 0);
            row1.createCell(0).setCellValue("ID_PROKER");
            row1.createCell(1).setCellValue("DOSEN_PENANGGUNG");
            row1.createCell(2).setCellValue("PERIODE_PROKER");
            row1.createCell(3).setCellValue("REVISI_PROKER");
            row1.createCell(4).setCellValue("URAIAN_PROKER");
            row1.createCell(5).setCellValue("STATUS_WADEK");
            row1.createCell(6).setCellValue("STATUS_DEKAN");
            row1.createCell(7).setCellValue("ANGGARAN_DANA");
            row1.createCell(8).setCellValue("TGLPERENCANAAN");

            Row row2;
            ResultSet rs = s.executeQuery("SELECT * FROM proker");
            while (rs.next()) {
                int a = rs.getRow();
                row2 = worksheet.createRow((short) a);
                // Sesuaikan dengan Jumlah Field
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                row2.createCell(5).setCellValue(rs.getString(6));
                row2.createCell(6).setCellValue(rs.getString(7));
                row2.createCell(7).setCellValue(rs.getString(8));
                row2.createCell(8).setCellValue(rs.getString(9));

            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            s.close();
            JOptionPane.showMessageDialog(null, "Export Berhasil");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

//Operasi realasi set-get
    public Jabatan setjabatan(Jabatan jabatan) {
        return jabatan;
    }

    public Jabatan getProdi() {
        return jabatan;
    }

}
