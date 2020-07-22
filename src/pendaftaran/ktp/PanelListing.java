/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaran.ktp;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import pendaftaran.ktp.config.Config;
import pendaftaran.ktp.config.JpanelLoader;
import pendaftaran.ktp.model.PendaftaranModel;
import pendaftaran.ktp.model.TabelModelPendaftaran;
import pendaftaran.ktp.model.dao.ImplementAgama;
import pendaftaran.ktp.model.dao.ImplementKecamatan;
import pendaftaran.ktp.model.dao.ImplementKelurahan;
import pendaftaran.ktp.model.dao.ImplementPendaftaran;
import pendaftaran.ktp.model.dao.KecamatanDAO;
import pendaftaran.ktp.model.dao.KelurahanDAO;
import pendaftaran.ktp.model.dao.PendaftaranDAO;

/**
 *
 * @author kalfian
 */
public class PanelListing extends javax.swing.JPanel {

    /**
     * Creates new form PanelListing2
     */
    Config db = new Config();
    DefaultTableModel model;
    PendaftaranModel pm = new PendaftaranModel();
    private List<PendaftaranModel> list;
    private final ImplementPendaftaran implementPendaftaran;
    
    private ArrayList<String> listKec,listKelurahan;
    private final ImplementKelurahan implementKelurahan;
    private final ImplementKecamatan implementKecamatan;
    
    private static String idKec = "1";
    private static String idKel = null;
    private static String kewarganegaraan = null;
    private static String status = null;
    private static String cari = null;
    
    public PanelListing() {
        initComponents();
        implementKelurahan = new KelurahanDAO();
        implementKecamatan = new KecamatanDAO();
        implementPendaftaran = new PendaftaranDAO();
        list = implementPendaftaran.getAllPendaftaran();
        getData();
        
        //
        listKec = implementKecamatan.getKecamatan();
        listKelurahan = implementKelurahan.getKelurahan(1);
        
        selKecamatan.setModel(new DefaultComboBoxModel<String>(listKec.toArray(new String[0])));
        selKelurahan.setModel(new DefaultComboBoxModel<String>(listKelurahan.toArray(new String[0])));
    }
    
    public void getData(){
        list = implementPendaftaran.getAllPendaftaran();
        jTable1.setModel(new TabelModelPendaftaran(list));
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        selKecamatan = new javax.swing.JComboBox<>();
        selKelurahan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        rdWNI = new javax.swing.JRadioButton();
        rdWNA = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        printBtn = new javax.swing.JToggleButton();
        resetBtn = new javax.swing.JToggleButton();

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
        RightClick.add(edit);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listing Pendaftaran E-KTP");

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

        selKecamatan.setBackground(new java.awt.Color(255, 255, 255));
        selKecamatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selKecamatan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selKecamatanItemStateChanged(evt);
            }
        });

        selKelurahan.setBackground(new java.awt.Color(255, 255, 255));
        selKelurahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selKelurahan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selKelurahanItemStateChanged(evt);
            }
        });

        jLabel2.setText("Kecamatan");

        jLabel3.setText("Kelurahan");

        jLabel4.setText("Kewarganegaraan");

        jLabel5.setText("Status Perkawinan");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Kawin");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton1MousePressed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Belum Kawin");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton2MousePressed(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Cerai");
        jRadioButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton6MousePressed(evt);
            }
        });

        buttonGroup1.add(rdWNI);
        rdWNI.setText("WNI");
        rdWNI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdWNIMousePressed(evt);
            }
        });

        buttonGroup1.add(rdWNA);
        rdWNA.setText("WNA");
        rdWNA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rdWNAMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Filter");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selKelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdWNI)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton6))
                            .addComponent(rdWNA))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(selKelurahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdWNI)
                    .addComponent(rdWNA))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton6))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        printBtn.setBackground(new java.awt.Color(0, 204, 204));
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

        resetBtn.setBackground(new java.awt.Color(0, 204, 204));
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset Filter");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(printBtn)
                    .addComponent(resetBtn))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selKecamatanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selKecamatanItemStateChanged
        int kecIdx = selKecamatan.getSelectedIndex();
        idKec = new KecamatanDAO().idKecamatan.get(kecIdx);
        listKelurahan = implementKelurahan.getKelurahan(parseInt(idKec));
        selKelurahan.setModel(new DefaultComboBoxModel<String>(listKelurahan.toArray(new String[0])));
        if(!txtCari.getText().equals("")){
            cari = txtCari.getText();
        }
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,cari);
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_selKecamatanItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printBtnActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        if(evt.getButton() == MouseEvent.BUTTON3){
           if(evt.isPopupTrigger() && jTable1.getSelectedRowCount() != 0){
               RightClick.show(evt.getComponent(),evt.getX(),evt.getY());
           }
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if(evt.getButton() == MouseEvent.BUTTON3){
           if(evt.isPopupTrigger() && jTable1.getSelectedRowCount() != 0){
               RightClick.show(evt.getComponent(),evt.getX(),evt.getY());
           }
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailMouseClicked
        
    }//GEN-LAST:event_detailMouseClicked

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            String kode = jTable1.getValueAt(row, 0).toString();
            PendaftaranModel pm = new PendaftaranModel();
            pm.setKodePendaftaran(kode);
            implementPendaftaran.getByKode(parseInt(kode));
            
            PanelDetail detail;
            try {
                detail = new PanelDetail();
                Dashboard dashboard = new Dashboard();
                dashboard.jpload.jPanelLoader(PanelListing.this, detail);
            } catch (IOException ex) {
                Logger.getLogger(PanelListing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_detailActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        
    }//GEN-LAST:event_txtCariKeyPressed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,txtCari.getText());
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_txtCariKeyReleased

    private void selKelurahanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selKelurahanItemStateChanged
        int kelIdx = selKelurahan.getSelectedIndex();
        idKel = new KelurahanDAO().IdKelurahan.get(kelIdx);
        if(!txtCari.getText().equals("")){
            cari = txtCari.getText();
        }
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,cari);
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_selKelurahanItemStateChanged

    private void rdWNIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdWNIMousePressed
        kewarganegaraan = "WNI";
        if(!txtCari.getText().equals("")){
            cari = txtCari.getText();
        }
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,cari);
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_rdWNIMousePressed

    private void rdWNAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdWNAMousePressed
        kewarganegaraan = "WNA";
        if(!txtCari.getText().equals("")){
            cari = txtCari.getText();
        }
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,cari);
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_rdWNAMousePressed

    private void jRadioButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MousePressed
        status = "kawin";
        if(!txtCari.getText().equals("")){
            cari = txtCari.getText();
        }
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,cari);
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_jRadioButton1MousePressed

    private void jRadioButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MousePressed
        status = "belum kawin";
        if(!txtCari.getText().equals("")){
            cari = txtCari.getText();
        }
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,cari);
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_jRadioButton2MousePressed

    private void jRadioButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton6MousePressed
        status = "cerai";
        if(!txtCari.getText().equals("")){
            cari = txtCari.getText();
        }
        list = implementPendaftaran.filterPendaftaran(idKec,idKel,kewarganegaraan,status,cari);
        jTable1.setModel(new TabelModelPendaftaran(list));
    }//GEN-LAST:event_jRadioButton6MousePressed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        clearAllInput();
    }//GEN-LAST:event_resetBtnActionPerformed
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
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu RightClick;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenuItem detail;
    private javax.swing.JMenuItem edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton printBtn;
    private javax.swing.JRadioButton rdWNA;
    private javax.swing.JRadioButton rdWNI;
    private javax.swing.JToggleButton resetBtn;
    private javax.swing.JComboBox<String> selKecamatan;
    private javax.swing.JComboBox<String> selKelurahan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
