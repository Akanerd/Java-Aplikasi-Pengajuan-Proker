/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class menu_wadek extends javax.swing.JFrame {

    /**
     * Creates new form menu_wadek
     */
      int xx,yy;
    public menu_wadek() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datajabatan = new javax.swing.JLabel();
        dataproker = new javax.swing.JLabel();
        datadiri = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        riwayat = new javax.swing.JLabel();
        m_dekan = new javax.swing.JLabel();

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

        datajabatan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datajabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datajabatanMouseClicked(evt);
            }
        });
        getContentPane().add(datajabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 130, 180));

        dataproker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dataproker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataprokerMouseClicked(evt);
            }
        });
        getContentPane().add(dataproker, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 120, 180));

        datadiri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datadiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datadiriMouseClicked(evt);
            }
        });
        getContentPane().add(datadiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 130, 190));

        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 60, 70));

        riwayat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        riwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayatMouseClicked(evt);
            }
        });
        getContentPane().add(riwayat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 110, 130, 190));

        m_dekan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_image/menu-home.png"))); // NOI18N
        getContentPane().add(m_dekan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datadiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datadiriMouseClicked
        menudosenwadek menu = new menudosenwadek();
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_datadiriMouseClicked

    private void dataprokerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataprokerMouseClicked
        menuprokerwakildekan menu = new menuprokerwakildekan();
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_dataprokerMouseClicked

    private void datajabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datajabatanMouseClicked
        menujabatanwadek menu = new menujabatanwadek();
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_datajabatanMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        login log = new login();
        log.setVisible(true);
        log.pack();
        log.setLocationRelativeTo(null);
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void riwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayatMouseClicked
        riwayatprokerwadek rt = new riwayatprokerwadek();
        rt.setVisible(true);
        rt.pack();
        rt.setLocationRelativeTo(null);
        rt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_riwayatMouseClicked

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
            java.util.logging.Logger.getLogger(menu_wadek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_wadek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_wadek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_wadek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_wadek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datadiri;
    private javax.swing.JLabel datajabatan;
    private javax.swing.JLabel dataproker;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel m_dekan;
    private javax.swing.JLabel riwayat;
    // End of variables declaration//GEN-END:variables
}
