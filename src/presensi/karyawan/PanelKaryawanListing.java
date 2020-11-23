/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presensi.karyawan;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import presensi.karyawan.config.Config;
import presensi.karyawan.config.Constant;
//import pendaftaran.ktp.config.Config;
//import pendaftaran.ktp.config.JpanelLoader;
import presensi.karyawan.config.JpanelLoader;
import presensi.karyawan.model.KaryawanModel;
//import pendaftaran.ktp.model.PendaftaranModel;
//import pendaftaran.ktp.model.TabelModelPendaftaran;
//import pendaftaran.ktp.model.dao.ImplementAgama;
//import pendaftaran.ktp.model.dao.ImplementKecamatan;
//import pendaftaran.ktp.model.dao.ImplementKelurahan;
//import pendaftaran.ktp.model.dao.ImplementPendaftaran;
//import pendaftaran.ktp.model.dao.KecamatanDAO;
//import pendaftaran.ktp.model.dao.KelurahanDAO;
//import pendaftaran.ktp.model.dao.PendaftaranDAO;
import presensi.karyawan.dao.*;
import presensi.karyawan.model.*;

/**
 *
 * @author kalfian
 */
public class PanelKaryawanListing extends javax.swing.JPanel {
    Preferences pref = Preferences.userNodeForPackage(presensi.karyawan.PanelKaryawanListing.class);

    /**
     * Creates new form PanelListing2
     */
    Config db = new Config();
    DefaultTableModel model;
    KaryawanModel km = new KaryawanModel();
    private List<KaryawanModel> list;
    
    private static String idKec = "1";
    private static String idKel = null;
    private static String kewarganegaraan = null;
    private static String status = null;
    private static String cari = null;
    private ArrayList<String> listJabatan;
    private final ImplementJabatan implementJabatan;
    private final ImplementKaryawan implementKaryawan;
    
    public PanelKaryawanListing() {
        initComponents();
        implementJabatan = new JabatanDAO();
        implementKaryawan = new KaryawanDAO();
        
        listJabatan = implementJabatan.getJabatan();
        selJabatan.setModel(new DefaultComboBoxModel<String>(listJabatan.toArray(new String[0])));
//        implementKecamatan = new KecamatanDAO();
//        implementPendaftaran = new PendaftaranDAO();
//        list = implementPendaftaran.getAllPendaftaran();
        getData();
//        
//        //
//        listKec = implementKecamatan.getKecamatan();
//        listKelurahan = implementKelurahan.getKelurahan(1);
//        
//        selKecamatan.setModel(new DefaultComboBoxModel<String>(listKec.toArray(new String[0])));
//        selKelurahan.setModel(new DefaultComboBoxModel<String>(listKelurahan.toArray(new String[0])));
    }
    
    public void getData(){
        list = implementKaryawan.getAllKaryawan();
        jTable1.setModel(new TabelModelKaryawan(list));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RightClick = new javax.swing.JPopupMenu();
        detail = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rdPerempuan = new javax.swing.JRadioButton();
        rdLaki = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        rdAktif = new javax.swing.JRadioButton();
        rdNonAktif = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        selJabatan = new javax.swing.JComboBox<String>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        txtCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        detail.setText("Detail");
        detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailMouseClicked(evt);
            }
        });
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });
        RightClick.add(detail);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        RightClick.add(edit);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        RightClick.add(delete);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kelola Karyawan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Nama");

        jLabel9.setText("Email");

        jLabel10.setText("Alamat");

        jLabel11.setText("Password");

        jLabel12.setText("Status");

        buttonGroup1.add(rdPerempuan);
        rdPerempuan.setText("Perempuan");

        buttonGroup1.add(rdLaki);
        rdLaki.setText("Laki - Laki");

        jLabel13.setText("Jenis Kelamin");

        buttonGroup2.add(rdAktif);
        rdAktif.setText("Aktif");

        buttonGroup2.add(rdNonAktif);
        rdNonAktif.setText("Non-Aktif");

        jLabel14.setText("Jabatan");

        selJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(selJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(rdLaki)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rdPerempuan))
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(230, 230, 230))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdAktif)
                                .addGap(18, 18, 18)
                                .addComponent(rdNonAktif))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addComponent(txtPassword))
                            .addComponent(jLabel12))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdPerempuan)
                            .addComponent(rdLaki)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNonAktif)
                            .addComponent(rdAktif))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jToggleButton1.setBackground(new java.awt.Color(187, 19, 19));
        jToggleButton1.setText("Delete");

        jToggleButton2.setText("Save");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Clear");

        jToggleButton4.setText("Update");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        jLabel6.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if (row==-1){
            return;
        }
        String idKaryawan = new KaryawanDAO().idKaryawan.get(row);
        //autofill
        list = implementKaryawan.getKaryawanById(parseInt(idKaryawan));
        
        txtNama.setText(list.get(0).getNama());
        txtEmail.setText(list.get(0).getEmail());
        txtAlamat.setText(list.get(0).getAlamat());
        int jk = list.get(0).getJk();
        if (jk == 1) {
            rdLaki.setSelected(true);
        } else {
            rdPerempuan.setSelected(true);
        }
        
        int status = list.get(0).getStatus();
        
        if (status == 1){
            rdAktif.setSelected(true);
        } else {
            rdNonAktif.setSelected(true);
        }
        int jabatan = list.get(0).getJabatan();
        int jabatanIdx = listJabatan.indexOf("SuperAdmin");
        selJabatan.setSelectedIndex(jabatanIdx);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
    }//GEN-LAST:event_jTable1MousePressed

    private void detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailMouseClicked
        
    }//GEN-LAST:event_detailMouseClicked

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
//        int row = jTable1.getSelectedRow();
//        if (row != -1) {
//            String kode = jTable1.getValueAt(row, 0).toString();
//            PendaftaranModel pm = new PendaftaranModel();
//            pm.setKodePendaftaran(kode);
//            implementPendaftaran.getByKode(parseInt(kode));
//            
//            PanelDetail detail;
//            try {
//                detail = new PanelDetail();
//                Dashboard dashboard = new Dashboard();
//                dashboard.jpload.jPanelLoader(PanelKaryawanListing.this, detail);
//            } catch (IOException ex) {
//                Logger.getLogger(PanelKaryawanListing.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_detailActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        
    }//GEN-LAST:event_txtCariKeyPressed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
//        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,txtCari.getText());
//        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_txtCariKeyReleased

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
//        int row = jTable1.getSelectedRow();
//        if (row != -1) {
//            try {
//                String kode = jTable1.getValueAt(row, 0).toString();
//                PendaftaranModel pm = new PendaftaranModel();
//                pm.setKodePendaftaranDetail(kode);
//                implementPendaftaran.getByKode(parseInt(kode));
//                PanelEdit edit;
//                edit = new PanelEdit();
//                Dashboard dashboard = new Dashboard();
//                dashboard.jpload.jPanelLoader(PanelKaryawanListing.this, edit);
//            } catch (IOException ex) {
//                Logger.getLogger(PanelKaryawanListing.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
//        int row = jTable1.getSelectedRow();
//        if (row != -1) {
//            String kode = jTable1.getValueAt(row, 0).toString();
//            PendaftaranModel pm = new PendaftaranModel();
//            int log = JOptionPane.showConfirmDialog(this, "Yakin Ingin menghapus data ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
//            if (log == 0) {
//                try {
//                    implementPendaftaran.delete(parseInt(kode));
//                } catch(Exception e) {
//                    System.err.print(e.getMessage());
//                }
//                getData();
//            }
//        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        KaryawanModel km = new KaryawanModel();
        km.setNama(txtNama.getText());
        km.setEmail(txtEmail.getText());
        km.setAlamat(txtAlamat.getText());
        km.setPassword(txtPassword.getText());
        int jk = 0;
        if (rdLaki.isSelected()) {
            jk = 1;
        }
        km.setJk(jk);
        
        int status = 0;
        if (rdAktif.isSelected()) {
            status = 1;
        }
        km.setStatus(status);
        km.setId(pref.getInt(Constant.PREF_ID, 0));
        String idJabatan = new JabatanDAO().idJabatan.get(selJabatan.getSelectedIndex());
        km.setJabatan(parseInt(idJabatan));
        implementKaryawan.insert(km);
        clearAllInput();
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    public void clearAllInput(){
        txtCari.setText("");
        for(Component control : jPanel2.getComponents())
        {
            if(control instanceof JTextField)
            {
                JTextField ctrl = (JTextField) control;
                ctrl.setText("");
            }
            else if (control instanceof JComboBox)
            {
                JComboBox ctr = (JComboBox) control;
                ctr.setSelectedIndex(0);
            }
        }
        
        for(Component control : jPanel3.getComponents())
        {
            if(control instanceof JTextField)
            {
                JTextField ctrl = (JTextField) control;
                ctrl.setText("");
            }
            else if (control instanceof JComboBox)
            {
                JComboBox ctr = (JComboBox) control;
                ctr.setSelectedIndex(0);
            }
        }
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        
        getData();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu RightClick;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenuItem detail;
    private javax.swing.JMenuItem edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JRadioButton rdAktif;
    private javax.swing.JRadioButton rdLaki;
    private javax.swing.JRadioButton rdNonAktif;
    private javax.swing.JRadioButton rdPerempuan;
    private javax.swing.JComboBox<String> selJabatan;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
