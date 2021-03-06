package gui;

import inti.Jabatan;
import inti.Koneksi;
import inti.Proker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class menuprokerkaprodi extends javax.swing.JFrame {

    /**
     * Creates new form menuprokerkaprodi
     */
    int xx, yy;

    public menuprokerkaprodi() {
        initComponents();
        id_proker.setBackground(new java.awt.Color(0, 0, 0, 1));
        dosen_png.setBackground(new java.awt.Color(0, 0, 0, 1));
        uraian.setBackground(new java.awt.Color(0, 0, 0, 1));
        anggaran_proker.setBackground(new java.awt.Color(0, 0, 0, 1));
        Proker s = new Proker();
        Jabatan p = new Jabatan();
        id_proker.setText(s.autoid());
        DefaultTableModel modelTable = (DefaultTableModel) viewprodi.getModel();
        modelTable.setRowCount(0);
        p.getproker();
        try {
            Iterator it = p.getIteratorProker();
            Object[] info = new Object[10];
            while (it.hasNext()) {
                s = (Proker) it.next();
                info[0] = s.getdosen();
                info[1] = s.getIdproker();
                info[2] = s.getDosenPenanggung();
                info[3] = s.getUraianProker();
                info[4] = s.getPeriodeProker();
                info[5] = s.getAnggaranDana();
                info[6] = s.getTglperencanaan();
                modelTable.addRow(info);
            }
        } catch (Exception e) {
            System.out.println("Error Terletak pada ini " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        id_proker = new javax.swing.JTextField();
        dosen_png = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        uraian = new javax.swing.JTextArea();
        periode_prkr = new javax.swing.JComboBox<>();
        anggaran_proker = new javax.swing.JTextField();
        tanggalan = new com.toedter.calendar.JDateChooser();
        scroll_view = new javax.swing.JScrollPane();
        viewprodi = new javax.swing.JTable();
        cari = new javax.swing.JComboBox<>();
        simpandata = new javax.swing.JLabel();
        ubahdata = new javax.swing.JLabel();
        hapus_data = new javax.swing.JLabel();
        backdata = new javax.swing.JLabel();
        caridata = new javax.swing.JLabel();
        m_kaprodi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id_proker.setBorder(null);
        getContentPane().add(id_proker, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 60, 20));

        dosen_png.setBorder(null);
        getContentPane().add(dosen_png, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 150, 30));

        uraian.setColumns(20);
        uraian.setRows(5);
        uraian.setText("Masukkan Data Proker");
        uraian.setBorder(null);
        jScrollPane1.setViewportView(uraian);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 170, 50));

        periode_prkr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015/2016", "2016/2017", "2017/2018", "2019/2020", "2020/2021" }));
        getContentPane().add(periode_prkr, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 170, 30));

        anggaran_proker.setBorder(null);
        getContentPane().add(anggaran_proker, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 160, 20));
        getContentPane().add(tanggalan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 170, 30));

        viewprodi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kaprodi", "ID Proker", "Dosen penanggung", "Uraian", "Periode", "Anggaran", "tgl perencanaan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewprodi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewprodiMouseClicked(evt);
            }
        });
        scroll_view.setViewportView(viewprodi);

        getContentPane().add(scroll_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 720, 320));

        cari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015/2016", "2016/2017", "2017/2018", "2018/2019", "2019/2020", "2020/2021" }));
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, 130, 30));

        simpandata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpandata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpandataMouseClicked(evt);
            }
        });
        getContentPane().add(simpandata, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 150, 40));

        ubahdata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ubahdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubahdataMouseClicked(evt);
            }
        });
        getContentPane().add(ubahdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 150, 40));

        hapus_data.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapus_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapus_dataMouseClicked(evt);
            }
        });
        getContentPane().add(hapus_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 150, 40));

        backdata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backdataMouseClicked(evt);
            }
        });
        getContentPane().add(backdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 160, 40));

        caridata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        caridata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caridataMouseClicked(evt);
            }
        });
        getContentPane().add(caridata, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 90, 150, 30));

        m_kaprodi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_image/proker-kaprodi.png"))); // NOI18N
        getContentPane().add(m_kaprodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpandataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpandataMouseClicked
        Proker p = new Proker();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String bdate = sdf.format(tanggalan.getDate());
        if (id_proker.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            id_proker.requestFocus();
        } else if (dosen_png.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            dosen_png.requestFocus();
        } else if (periode_prkr.getSelectedItem().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            periode_prkr.requestFocus();
        } else if (anggaran_proker.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            anggaran_proker.requestFocus();
        } else {
            p.setIdproker(id_proker.getText());
            p.setDosenPenanggung(dosen_png.getText());
            p.setUraianProker(uraian.getText());
            p.setPeriodeProker(periode_prkr.getSelectedItem().toString());
            p.setAnggaranDana(anggaran_proker.getText());
            p.setTglperencanaan(bdate);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Menyimpan Data ?");
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    p.insert();
                } catch (Exception ex) {
                    System.out.println("Error Terletak Pada : " + ex);
                }
            } else if (dialogResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Silahkan Menginputkan Data Lagi");
            } else if (dialogResult == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Anda Membatalkan Input Data");
            }
        }
        Proker s = new Proker();
        DefaultTableModel modelTable = (DefaultTableModel) viewprodi.getModel();
        modelTable.setRowCount(0);
        Object[] info = new Object[10];
        try {
            ArrayList prokerall = s.viewAll(); //harus dikasih try catch
            Iterator it = prokerall.iterator();
            System.out.println("size: " + prokerall.size()); //ok
            while (it.hasNext()) {
                s = (Proker) it.next();
                info[0] = s.getdosen();
                info[1] = s.getIdproker();
                info[2] = s.getDosenPenanggung();
                info[3] = s.getUraianProker();
                info[4] = s.getPeriodeProker();
                info[5] = s.getAnggaranDana();
                info[6] = s.getTglperencanaan();
                modelTable.addRow(info);
            }
            viewprodi.setModel(modelTable);
        } catch (Exception ex) {
            System.out.println("Error Terletak Pada Ini : " + ex);
        }

    }//GEN-LAST:event_simpandataMouseClicked

    private void viewprodiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewprodiMouseClicked
        DefaultTableModel model = (DefaultTableModel) viewprodi.getModel();
        int row = viewprodi.getSelectedRow();
        id_proker.setText(model.getValueAt(row, 1).toString());
        dosen_png.setText(model.getValueAt(row, 2).toString());
        uraian.setText(model.getValueAt(row, 3).toString());
        periode_prkr.setSelectedItem(model.getValueAt(row, 4).toString());
        anggaran_proker.setText(model.getValueAt(row, 5).toString());
//        tanggalan.setDateFormatString(model.getValueAt(row, 5).toString());

    }//GEN-LAST:event_viewprodiMouseClicked

    private void ubahdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubahdataMouseClicked
        Proker p = new Proker();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String bdate = sdf.format(tanggalan.getDate());
        if (id_proker.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            id_proker.requestFocus();
        } else if (dosen_png.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            dosen_png.requestFocus();
        } else if (periode_prkr.getSelectedItem().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            periode_prkr.requestFocus();
        } else if (anggaran_proker.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            anggaran_proker.requestFocus();
        } else {
            p.setIdproker(id_proker.getText());
            p.setDosenPenanggung(dosen_png.getText());
            p.setUraianProker(uraian.getText());
            p.setPeriodeProker(periode_prkr.getSelectedItem().toString());
            p.setAnggaranDana(anggaran_proker.getText());
            p.setTglperencanaan(bdate);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Menyimpan Data ?");
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    p.updatekaprodi();
                } catch (Exception ex) {
                    System.out.println("Error Terletak Pada : " + ex);
                }
            } else if (dialogResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Silahkan Menginputkan Data Lagi");
            } else if (dialogResult == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Anda Membatalkan Input Data");
            }
        }
        Proker s = new Proker();
        DefaultTableModel modelTable = (DefaultTableModel) viewprodi.getModel();
        modelTable.setRowCount(0);
        Object[] info = new Object[10];
        try {
            ArrayList prokerall = s.viewAll(); //harus dikasih try catch
            Iterator it = prokerall.iterator();
            System.out.println("size: " + prokerall.size()); //ok
            while (it.hasNext()) {
                s = (Proker) it.next();
                info[0] = s.getdosen();
                info[1] = s.getIdproker();
                info[2] = s.getDosenPenanggung();
                info[3] = s.getUraianProker();
                info[4] = s.getPeriodeProker();
                info[5] = s.getAnggaranDana();
                info[6] = s.getTglperencanaan();
                modelTable.addRow(info);
            }
            viewprodi.setModel(modelTable);
        } catch (Exception ex) {
            System.out.println("Error Terletak Pada Ini : " + ex);
        }

    }//GEN-LAST:event_ubahdataMouseClicked

    private void hapus_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapus_dataMouseClicked
        Proker p = new Proker();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String bdate = sdf.format(tanggalan.getDate());
        if (id_proker.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            id_proker.requestFocus();
        } else if (dosen_png.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            dosen_png.requestFocus();
        } else if (periode_prkr.getSelectedItem().toString().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            periode_prkr.requestFocus();
        } else if (anggaran_proker.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh kosong");
            anggaran_proker.requestFocus();
        } else {
            p.setIdproker(id_proker.getText());
            p.setDosenPenanggung(dosen_png.getText());
            p.setUraianProker(uraian.getText());
            p.setPeriodeProker(periode_prkr.getSelectedItem().toString());
            p.setAnggaranDana(anggaran_proker.getText());
            p.setTglperencanaan(bdate);
            int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Menghapus Data ?");
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    p.delete();
                } catch (Exception ex) {
                    System.out.println("Error Terletak Pada : " + ex);
                }
            } else if (dialogResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Silahkan Menginputkan Data Lagi");
            } else if (dialogResult == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Anda Membatalkan Input Data");
            }
        }
        Proker s = new Proker();
        DefaultTableModel modelTable = (DefaultTableModel) viewprodi.getModel();
        modelTable.setRowCount(0);
        Object[] info = new Object[10];
        try {
            ArrayList prokerall = s.viewAll(); //harus dikasih try catch
            Iterator it = prokerall.iterator();
            System.out.println("size: " + prokerall.size()); //ok
            while (it.hasNext()) {
                s = (Proker) it.next();
                info[0] = s.getdosen();
                info[1] = s.getIdproker();
                info[2] = s.getDosenPenanggung();
                info[3] = s.getUraianProker();
                info[4] = s.getPeriodeProker();
                info[5] = s.getAnggaranDana();
                info[6] = s.getTglperencanaan();
                modelTable.addRow(info);
            }
            viewprodi.setModel(modelTable);
        } catch (Exception ex) {
            System.out.println("Error Terletak Pada Ini : " + ex);
        }
    }//GEN-LAST:event_hapus_dataMouseClicked

    private void backdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backdataMouseClicked
        menu_kaprodi md = new menu_kaprodi();
        md.setVisible(true);
        md.pack();
        md.setLocationRelativeTo(null);
        md.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backdataMouseClicked

    private void caridataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caridataMouseClicked
        Proker p = new Proker();
        DefaultTableModel tb = (DefaultTableModel) viewprodi.getModel();
        tb.setRowCount(0);
        try {
            p.viewAllfilterkaprodi(tb, cari.getSelectedItem().toString());

        } catch (Exception ex) {
            System.out.println("Error Terletak Pada Ini : " + ex);
        }

    }//GEN-LAST:event_caridataMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_formMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuprokerkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuprokerkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuprokerkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuprokerkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuprokerkaprodi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anggaran_proker;
    private javax.swing.JLabel backdata;
    private javax.swing.JComboBox<String> cari;
    private javax.swing.JLabel caridata;
    private javax.swing.JTextField dosen_png;
    private javax.swing.JLabel hapus_data;
    public javax.swing.JTextField id_proker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel m_kaprodi;
    private javax.swing.JComboBox<String> periode_prkr;
    private javax.swing.JScrollPane scroll_view;
    private javax.swing.JLabel simpandata;
    private com.toedter.calendar.JDateChooser tanggalan;
    private javax.swing.JLabel ubahdata;
    private javax.swing.JTextArea uraian;
    private javax.swing.JTable viewprodi;
    // End of variables declaration//GEN-END:variables
}
