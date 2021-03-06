/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import inti.Dosen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class menudosenkaprodi extends javax.swing.JFrame {

    /**
     * Creates new form menudosenkaprodi
     */
    int xx, yy;

    public menudosenkaprodi() {
        initComponents();
        npp.setBackground(new java.awt.Color(0, 0, 0, 1));
        nama.setBackground(new java.awt.Color(0, 0, 0, 1));
        ttl.setBackground(new java.awt.Color(0, 0, 0, 1));
        jk.setBackground(new java.awt.Color(0, 0, 0, 1));
        alamat.setBackground(new java.awt.Color(0, 0, 0, 1));
        email.setBackground(new java.awt.Color(0, 0, 0, 1));
        Dosen ds = new Dosen("21833019");
        npp.setText(ds.getNpp());
        nama.setText(ds.getNamaDosen());
        ttl.setText(ds.getTtlDosen());
        jk.setText(ds.getJkDosen());
        agama.setSelectedItem(ds.getAgamaDosen());
        alamat.setText(ds.getAlamatDosen());
        email.setText(ds.getEmailDosen());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        npp = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        ttl = new javax.swing.JTextField();
        jk = new javax.swing.JTextField();
        agama = new javax.swing.JComboBox<>();
        alamat = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        backtomenu = new javax.swing.JLabel();
        simpandata = new javax.swing.JLabel();
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

        npp.setEditable(false);
        npp.setBorder(null);
        getContentPane().add(npp, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 160, 20));

        nama.setEditable(false);
        nama.setBorder(null);
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 160, 20));

        ttl.setEditable(false);
        ttl.setBorder(null);
        getContentPane().add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 150, 20));

        jk.setEditable(false);
        jk.setBorder(null);
        getContentPane().add(jk, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 150, 20));

        agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Kristen", "Hindu", "Budha", "Konghucu", "custom" }));
        getContentPane().add(agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 160, -1));

        alamat.setBorder(null);
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 150, 20));

        email.setBorder(null);
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 150, 30));

        backtomenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backtomenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtomenuMouseClicked(evt);
            }
        });
        getContentPane().add(backtomenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 140, 40));

        simpandata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpandata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpandataMouseClicked(evt);
            }
        });
        getContentPane().add(simpandata, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 150, 40));

        m_kaprodi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_image/menu-dosen.png"))); // NOI18N
        getContentPane().add(m_kaprodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpandataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpandataMouseClicked
        Dosen ds = new Dosen();
        if (alamat.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            alamat.requestFocus();
        } else if (email.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            email.requestFocus();
        } else {
            ds.setAgamaDosen(agama.getSelectedItem().toString());
            ds.setAlamatDosen(alamat.getText());
            ds.setEmailDosen(email.getText());
            ds.setNpp(npp.getText());
            int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Memperbarui Data diri?", null, JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    ds.update();
                } catch (Exception ex) {
                    System.out.println("Error Terletak Pada : " + ex);
                }
            } else if (dialogResult == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Anda telah membatalkan Input data");
            }
        }
    }//GEN-LAST:event_simpandataMouseClicked

    private void backtomenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtomenuMouseClicked
        menu_kaprodi menu = new menu_kaprodi();
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backtomenuMouseClicked

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
            java.util.logging.Logger.getLogger(menudosenkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menudosenkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menudosenkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menudosenkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menudosenkaprodi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> agama;
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel backtomenu;
    private javax.swing.JTextField email;
    private javax.swing.JTextField jk;
    private javax.swing.JLabel m_kaprodi;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField npp;
    private javax.swing.JLabel simpandata;
    private javax.swing.JTextField ttl;
    // End of variables declaration//GEN-END:variables
}
