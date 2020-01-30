/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelKebersihan;

import TabelPenghuni.daftarView;
import config.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class cleanView extends javax.swing.JFrame {
    DefaultTableModel model;
    Connection conn;
    ResultSet rs;
    
    Koneksi k = new Koneksi();
    /**
     * Creates new form cleanView
     */
    public cleanView() {
        initComponents();
        judul();
        tampil();
    }
    
    private void judul(){
        String[] header={"No","No Kamar","Nama","Jenis Kelamin","No Telp"};
        model = new DefaultTableModel(header,0);
        tbl_clean.setModel(model);
    }
    
    private void tampil(){
        try {
            int row = tbl_clean.getRowCount();
            for (int i = 0; i < row; i++) {
                model.removeRow(0);
            }
            
            conn = k.getKoneksi();
            rs = conn.createStatement().executeQuery("SELECT no_kamar,nama,jenis_kelamin,no_telp from tb_penghuni join tb_clean using(no_kamar)");
            int no =1;
            while (rs.next()) {
                String nok = rs.getString("no_kamar");
                String nama = rs.getString("nama");
                String jk = rs.getString("jenis_kelamin");
                String not = rs.getString("no_telp");
                String[] data={Integer.toString(no),nok,nama,jk,not};
                model.addRow(data);
                no++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(cleanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public String cari;
    private void cari_data(){
        cari = txt_cariKebersihan.getText();
        try {
            int row = tbl_clean.getRowCount();
            for (int i = 0; i < row; i++) {
                model.removeRow(0);
            }
            
            conn = k.getKoneksi();
            rs = conn.createStatement().executeQuery("SELECT no_kamar,nama,jenis_kelamin,no_telp FROM tb_penghuni JOIN tb_clean WHERE no_kamar='"+cari+"' ");
            int no = 1;
            while(rs.next()){
                String nok = rs.getString("no_kamar");
                String nama = rs.getString("nama");
                String jk = rs.getString("jenis_kelamin");
                String not = rs.getString("no_telp");
                String[] baris ={Integer.toString(no),nok,nama,jk,not};
                model.addRow(baris);
                no++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(daftarView.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        txt_nok = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_clean = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_cariKebersihan = new javax.swing.JButton();
        txt_cariKebersihan = new javax.swing.JTextField();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("No Kamar");

        txt_nok.setBackground(new java.awt.Color(255, 255, 255));
        txt_nok.setForeground(new java.awt.Color(0, 0, 0));

        tbl_clean.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_clean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cleanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_clean);

        btn_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_simpan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(0, 0, 0));
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tambah (1).png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(0, 0, 0));
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hapus.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        btn_cariKebersihan.setBackground(new java.awt.Color(255, 255, 255));
        btn_cariKebersihan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_cariKebersihan.setForeground(new java.awt.Color(0, 0, 0));
        btn_cariKebersihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btn_cariKebersihan.setText("Cari");
        btn_cariKebersihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariKebersihanActionPerformed(evt);
            }
        });

        txt_cariKebersihan.setBackground(new java.awt.Color(255, 255, 255));
        txt_cariKebersihan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_cariKebersihan.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cariKebersihan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cariKebersihan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_nok)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_simpan)
                                .addGap(30, 30, 30)
                                .addComponent(btn_hapus)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nok, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_hapus))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cariKebersihan)
                    .addComponent(txt_cariKebersihan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            // TODO add your handling code here:
            conn = k.getKoneksi();
            conn.createStatement().executeUpdate("INSERT INTO tb_clean VALUES('"+txt_nok.getText()+"')");
            tampil();
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(cleanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void tbl_cleanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cleanMouseClicked
        // TODO add your handling code here:
        int i = tbl_clean.getSelectedRow();
        txt_nok.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_tbl_cleanMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            // TODO add your handling code here:
            conn = k.getKoneksi();
            conn.createStatement().executeUpdate("DELETE FROM tb_clean where no_kamar='"+txt_nok.getText()+"' ");
            tampil();
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(cleanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_cariKebersihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariKebersihanActionPerformed
        // TODO add your handling code here:
        cari = txt_cariKebersihan.getText();
        if (cari.equals("")) {
            tampil();
        } else {
            cari_data();
        }
    }//GEN-LAST:event_btn_cariKebersihanActionPerformed
    
    private void reset(){
        txt_nok.setText("");
        txt_nok.requestFocus();
    }
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
            java.util.logging.Logger.getLogger(cleanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cleanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cleanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cleanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cleanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cariKebersihan;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_clean;
    private javax.swing.JTextField txt_cariKebersihan;
    private javax.swing.JTextField txt_nok;
    // End of variables declaration//GEN-END:variables
}