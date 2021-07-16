/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import inti.Jabatan;
import inti.Koneksi;
import inti.RiwayatJabatan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class riwayatkaprodi extends javax.swing.JFrame {

    /**
     * Creates new form riwayat
     */
    int xx,yy;
    public riwayatkaprodi() {
        initComponents();
        Jabatan x = new Jabatan("22833019");
        RiwayatJabatan rt = new RiwayatJabatan("22833019");
        DefaultTableModel tb = (DefaultTableModel) rwt.getModel();
        rt.getriwayat(tb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rwt = new javax.swing.JTable();
        backdosen = new javax.swing.JLabel();
        backtomenu = new javax.swing.JLabel();
        m_riwayat = new javax.swing.JLabel();

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

        rwt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jabatan After", "Jabatan Before", "Status After", "Status Before", "Periode After", "Periode Before"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rwt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 770, 275));

        backdosen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backdosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backdosenMouseClicked(evt);
            }
        });
        getContentPane().add(backdosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 150, 30));

        backtomenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backtomenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtomenuMouseClicked(evt);
            }
        });
        getContentPane().add(backtomenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 150, 30));

        m_riwayat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_image/menu-riwayat-jabatan.png"))); // NOI18N
        getContentPane().add(m_riwayat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backtomenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtomenuMouseClicked
        menu_kaprodi menu = new menu_kaprodi();
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backtomenuMouseClicked

    private void backdosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backdosenMouseClicked
        menujabatankaprodi menu = new menujabatankaprodi();
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backdosenMouseClicked

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
            java.util.logging.Logger.getLogger(riwayatkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(riwayatkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(riwayatkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(riwayatkaprodi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new riwayatkaprodi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backdosen;
    private javax.swing.JLabel backtomenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel m_riwayat;
    private javax.swing.JTable rwt;
    // End of variables declaration//GEN-END:variables
}
