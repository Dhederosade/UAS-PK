/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArsipDokumen;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.TableModel;
import sun.security.pkcs11.Secmod;





/**
 *
 * @author Sendie_YM
 */
public class ArsipDokumen extends javax.swing.JFrame {
    private Statement st;
    private ResultSet Rs;
    private String Host;
    private Connection Con;
    String tanggal1;

    /**
     * Creates new form Anggota
     */
    public ArsipDokumen() {
        initComponents();
        refresh();
        tampil();
        this.setLocationRelativeTo(null);//center form in the screen
        
    }
    

    private void refresh(){
             txtkode.setEditable(true);
             txtkode.setText(null);
             txtnama.setText(null);
             cbKategori.setSelectedItem(this);
             txtlokasi.setText(null);
             txtdeskripsi.setText(null);
             tgl.setCalendar(null);
    }
    private void tampil(){        
             DefaultTableModel model = new DefaultTableModel();
             model.addColumn("No.");
             model.addColumn("Kode Dokumen");
             model.addColumn("Nama Dokumen");
             model.addColumn("Kategori Dokumen");
             model.addColumn("Lokasi Dokumen");
             model.addColumn("Deskripsi Dokumen");
             model.addColumn("Tanggal");
             
            String cari = txtCari.getText();
            try{
                int no = 1;
                String sql = "SELECT * FROM tb_dokumen WHERE nama_dokumen LIKE '%"+cari+"%' OR kategori_dokumen LIKE '%"+cari+"%' OR lokasi_dokumen LIKE '%"+cari+"%' OR deskripsi_dokumen LIKE '%"+cari+"%';";
                java.sql.Connection conn = (Connection)Koneksi.configDB();                                                                                                                  
                java.sql.Statement stm = conn.createStatement();                
                java.sql.ResultSet res = stm.executeQuery(sql);
                
                while(res.next()){
                    model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
                }
                tblArsip.setModel(model);
            }catch (SQLException e){
                System.out.println("Error : " + e.getMessage());
            }
        }
    
        private void update_tabel() {
            DefaultTableModel model = new DefaultTableModel();
             model.addColumn("No.");
             model.addColumn("Kode Dokumen");
             model.addColumn("Nama Dokumen");
             model.addColumn("Kategori Dokumen");
             model.addColumn("Lokasi Dokumen");
             model.addColumn("Deskripsi Dokumen");
             model.addColumn("Tanggal");            
            try {
                int no =1;
                String sql = "SELECT * FROM tb_dokumen";
                java.sql.Connection conn = (Connection)Koneksi.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                while(res.next()){
                    model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
                }
                tblArsip.setModel(model);   
                
            }catch (SQLException e){
                System.out.println("Error : " + e.getMessage());
            }
        }
    
    
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtdeskripsi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArsip = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tgl = new com.toedter.calendar.JDateChooser();
        cbKategori = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtlokasi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(23, 192, 235));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buku.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(236, 240, 241));
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 52, 54));
        jLabel2.setText("Arsip Dokumen");

        jLabel3.setBackground(new java.awt.Color(236, 240, 241));
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 52, 54));
        jLabel3.setText("<");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(44, 66, 80));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Kode Dokumen");

        txtkode.setBackground(new java.awt.Color(228, 241, 254));
        txtkode.setForeground(new java.awt.Color(0, 0, 0));
        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        txtkode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkodeKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("Nama Dokumen");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("Kategori Dokumen");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Deskripsi Dokumen");

        txtnama.setBackground(new java.awt.Color(228, 241, 254));
        txtnama.setForeground(new java.awt.Color(0, 0, 0));

        txtdeskripsi.setBackground(new java.awt.Color(228, 241, 254));
        txtdeskripsi.setForeground(new java.awt.Color(0, 0, 0));
        txtdeskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeskripsiActionPerformed(evt);
            }
        });

        tblArsip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblArsip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArsipMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArsip);

        btnSimpan.setBackground(new java.awt.Color(44, 66, 80));
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tambah.png"))); // NOI18N
        btnSimpan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(44, 66, 80));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        btnEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(44, 66, 88), new java.awt.Color(44, 66, 88), new java.awt.Color(44, 66, 88), new java.awt.Color(44, 66, 80)));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(44, 66, 80));
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hapus.png"))); // NOI18N
        btnHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(44, 66, 88), new java.awt.Color(44, 66, 88), new java.awt.Color(44, 66, 88), new java.awt.Color(44, 66, 80)));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtCari.setBackground(new java.awt.Color(228, 241, 254));
        txtCari.setForeground(new java.awt.Color(108, 122, 137));
        txtCari.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.black, java.awt.Color.lightGray));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        tgl.setBackground(new java.awt.Color(108, 122, 137));
        tgl.setForeground(new java.awt.Color(108, 122, 137));
        tgl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglPropertyChange(evt);
            }
        });

        cbKategori.setBackground(new java.awt.Color(228, 241, 254));
        cbKategori.setForeground(new java.awt.Color(0, 0, 0));
        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Surat Masuk ", "Surat  Keluar", "Surat Ijin" }));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Lokasi Dokumen");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Tanggal");

        txtlokasi.setBackground(new java.awt.Color(228, 241, 254));
        txtlokasi.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtkode, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                            .addComponent(txtnama, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(76, 76, 76)
                                .addComponent(txtlokasi)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtCari)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtdeskripsi)
                                            .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addGap(223, 223, 223)
                        .addComponent(btnHapus))
                    .addComponent(jScrollPane1))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtdeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtlokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdeskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeskripsiActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        halamanUtama i = new halamanUtama();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        refresh();
        update_tabel();
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tgl.getDate()));
        
        //Pencegahan data kosong       
        String kode_dokumen,nama_dokumen,lokasi_dokumen,deskripsi_dokumen;
        kode_dokumen = txtkode.getText();
        nama_dokumen = txtnama.getText();
        lokasi_dokumen = txtlokasi.getText();
        deskripsi_dokumen = txtdeskripsi.getText();
        if (kode_dokumen.equals("") | (nama_dokumen.equals("")) | (lokasi_dokumen.equals("")) | (deskripsi_dokumen.equals(""))) {
            JOptionPane.showMessageDialog(null, "Pengisian Data Tidak Boleh Kosong");
            txtkode.requestFocus();
        }else{
            try {
            String sql = "INSERT INTO tb_dokumen (kode_dokumen,nama_dokumen,kategori_dokumen,lokasi_dokumen,deskripsi_dokumen,tanggal) VALUES ('"+txtkode.getText()+"','"+txtnama.getText()+"','"+cbKategori.getSelectedItem()+"','"+txtlokasi.getText()+"','"+txtdeskripsi.getText()+"','"+tanggal+"')";
            java.sql.Connection conn = (Connection)Koneksi.configDB();                                                                                                                                                                                                                  
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil.....");
            refresh();
            tampil();
            } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }    
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblArsipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArsipMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblArsip.getModel();
        
        int baris = tblArsip.rowAtPoint(evt.getPoint());
        
        String kode_dokumen = tblArsip.getValueAt(baris, 1).toString();
        txtkode.setText(kode_dokumen);
        
        String nama_dokumen = tblArsip.getValueAt(baris, 2).toString();
        txtnama.setText(nama_dokumen);
     
        String kategori_dokumen = tblArsip.getValueAt(baris, 3).toString();
        cbKategori.setSelectedItem(kategori_dokumen);
        
        String lokasi_dokumen = tblArsip.getValueAt(baris, 4).toString();
        txtlokasi.setText(lokasi_dokumen);
        
        String deskripsi_dokumen = tblArsip.getValueAt(baris, 5).toString();
        txtdeskripsi.setText(deskripsi_dokumen);
        
        String date = (String)tblArsip.getModel().getValueAt(baris, 6);
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-M-dd");
            java.util.Date d = f.parse(date);
            tgl.setDate(d);       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblArsipMouseClicked

    private void txtkodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeKeyPressed
        // TODO add your handling code here:
        String kode_dokumen  = txtkode.getText();
        int a = evt.getKeyCode();
        if (a==10){
            try {
               String Sql ="SELECT * FROM tb_dokumen WHERE kode_dokumen ="+kode_dokumen+"";
               st=Con.createStatement();
               Rs=st.executeQuery(Sql);
               while(Rs.next()){
                   txtnama.setText(Rs.getString(2));
                   cbKategori.setSelectedItem(Rs.getString(3));
                   txtlokasi.setText(Rs.getString(4));
                   txtdeskripsi.setText(Rs.getString(5));
                   tgl.setDate(Rs.getDate(6));
               }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null,"Data Not Found"+e.getMessage());
                txtkode.requestFocus();
            }
        }
    }//GEN-LAST:event_txtkodeKeyPressed
    
    private void tglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglPropertyChange
        // TODO add your handling code here:
        if(tgl.getDate()!=null){
            SimpleDateFormat Format  = new SimpleDateFormat("yyyy-MM-dd");
            tanggal1=Format.format(tgl.getDate());
        }
    }//GEN-LAST:event_tglPropertyChange

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tgl.getDate()));
            try{
                        String sql = "UPDATE tb_dokumen SET kode_dokumen ='"+txtkode.getText()+
                    "',nama_dokumen='"+txtnama.getText()+
                    "',kategori_dokumen='"+cbKategori.getSelectedItem()+
                    "',lokasi_dokumen='"+txtlokasi.getText()+
                    "',deskripsi_dokumen='"+txtdeskripsi.getText()+            
                    "',tanggal='"+tanggal+        
                    "' WHERE kode_dokumen ='"+txtkode.getText()+"' ";
            
            java.sql.Connection conn = (Connection)Koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            st=conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil...");
            
            tampil();
            refresh();
        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            String sql = "DELETE FROM tb_dokumen WHERE kode_dokumen='"+txtkode.getText()+"'";
            java.sql.Connection conn= (Connection)Koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil...");
        }catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());   
        }
        tampil();
        refresh();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        tampil();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodeActionPerformed


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
            java.util.logging.Logger.getLogger(ArsipDokumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArsipDokumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArsipDokumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArsipDokumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArsipDokumen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArsip;
    private com.toedter.calendar.JDateChooser tgl;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtdeskripsi;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
