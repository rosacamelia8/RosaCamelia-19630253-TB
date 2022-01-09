
package frame;

import db.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Krs;

public class KrsTampil extends javax.swing.JFrame {

    Krs krs;
    
    public KrsTampil() {
        initComponents();
        setLocationRelativeTo(null);
        resetTable("");
    }
    
    public ArrayList<Krs> getKrsList(String keyword){
        ArrayList<Krs> krsList = new ArrayList<Krs>();
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
//        String query = "SELECT mahasiswa.id*, kelas.* FROM mahasiswa "
//                    + "INNER JOIN kelas ON mahasiswa.id_kelas = kelas.id ";
//        String query = "SELECT mahasiswa.id, mahasiswa.nama_mahasiswa , "
//                    + "mahasiswa.jenis_kelamin, mahasiswa.tanggal_lahir , mahasiswa.agama, mahasiswa.id_kelas, "
//                    + "kelas.id, kelas.nama_kelas FROM mahasiswa "
//                    + "INNER JOIN kelas ON mahasiswa.id_kelas = kelas.id ";

//        String query = "SELECT krs.id.*, mahasiswa.*, matakuiah.* FROM ((krs "
//                + "INNER JOIN mahasiswa ON krs.id_mahasiswa = mahasiswa.id_mahasiiswa)"
//                + "INNER JOIN matakuliah ON krs.id_matakuiah = matakuliah.id_matakuliah)";

            String query = "SELECT krs.id, krs.id_matakuliah, krs.id_matakuliah, krs.semester, "
                    + "mahasiswa.id, mahasiswa.nama_mahasiswa, mahasiswa.kelas, matakuliah.id, "
                    + "matakuliah.kodemk, matakuliah.sks, matakuliah.dosen FROM ((krs "
                    + "INNER JOIN mahasiswa ON krs.id_mahasiswa = mahasiswa.id) "
                    + "INNER JOIN matakuliah ON krs.id_matakuliah = matakuliah.id) ";

        String order = " ORDER BY krs.id";  
        if(!keyword.equals(""))
            query = query+ " WHERE krs.id = ? id_mahasiswa ? = id_matakuliah ?";
        
        query = query+order;
        try {
            ps = connection.prepareStatement(query);
            if(!keyword.equals("")) {
                ps.setString(1, eCari.getText());
              ps.setString(2, "%"+eCari.getText()+"%");
            }
            rs = ps.executeQuery();
            while(rs.next()){
                krs = new Krs(
                        rs.getInt("krs.id"),
                        rs.getString("mahasiswa.id"),
                        rs.getString("matakuliah.id"),
                        rs.getString("mahasiswa.nama_mahasiswa"),
                        rs.getString("matakuliah.kodemk"),
                        rs.getString("matakuliah.matakuliah"),
                        rs.getString("sks"),
                        rs.getString("matakuliah.semester"),
                        rs.getString("matakuliah.dosen"));
                krsList.add(krs);
            }
        }catch (SQLException ex) {
            System.err.println("Error getKrsList : "+ex);
        }
        
        return krsList;    
    }
    
    public void selectKrs(String keyword){
        ArrayList<Krs> list = getKrsList(keyword);
        DefaultTableModel model =(DefaultTableModel)tKrs.getModel();
        Object[] row = new Object[8];
        
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getMahasiswa().getNamaMahasiswa();
            row[2] = list.get(i).getMatakuliah().getKodemk();
            row[3] = list.get(i).getMatakuliah().getMatakuliah();
            row[4] = list.get(i).getMatakuliah().getSks();
            row[5] = list.get(i).getSemester();
            row[6] = list.get(i).getMahasiswa().getKelas();
            row[7] = list.get(i).getMatakuliah().getDosen();
            
            model.addRow(row);
        }
    }
        
        public final void resetTable(String keyword) {
        DefaultTableModel model = (DefaultTableModel)tKrs.getModel();
        model.setRowCount(0);
        selectKrs(keyword);
    
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bTutup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        eCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tKrs = new javax.swing.JTable();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INPUT KRS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/exit.jpeg"))); // NOI18N
        bTutup.setText("Tutup");
        bTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTutupActionPerformed(evt);
            }
        });

        jLabel1.setText("Cari Mahasiswa");

        bCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/cari.jpeg"))); // NOI18N
        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        tKrs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Npm", "Nama Mahasiswa", "Kode Matakuliah", "Matakuliah", "Sks", "Semester", "Kelas", "Dosen"
            }
        ));
        jScrollPane1.setViewportView(tKrs);

        bTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/tambahkrs.jpeg"))); // NOI18N
        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/edit.jpeg"))); // NOI18N
        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/hapus.jpeg"))); // NOI18N
        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/batal.jpeg"))); // NOI18N
        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bTutup))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eCari)
                        .addGap(18, 18, 18)
                        .addComponent(bCari))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCari)
                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bUbah)
                    .addComponent(bHapus)
                    .addComponent(bBatal)
                    .addComponent(bTutup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTutupActionPerformed
        dispose();
    }//GEN-LAST:event_bTutupActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        resetTable(eCari.getText());
    }//GEN-LAST:event_bCariActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        KrsTambah krsTambah = new KrsTambah();
        krsTambah.setVisible(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
//        int i = tKrs.getSelectedRow();
//        if(i>=0) {
//            TableModel model = tKrs.getModel();
//            mahasiswa = new Mahasiswa();
//            mahasiswa.setId(model.getValueAt(1, 0).toString());
//            mahasiswa.setNamaMahasiswa(model.getValueAt(i, 1).toString());
//            mahasiswa.setJenisKelamin(model.getValueAt(i, 2).toString());
//            mahasiswa.setTanggalLahir(model.getValueAt(i, 3).toString());
//            mahasiswa.setAgama(model.getValueAt(i, 4).toString());
//            mahasiswa.setKelas(new Kelas
//                (Integer.parseInt(model.getValueAt(i, 5).toString()),
//                    model.getValueAt(i, 6).toString()));
//
//            MahasiswaTambah mahasiswaTambah = new MahasiswaTambah(mahasiswa);
//            mahasiswaTambah.setVisible(true);
//        }else{
//            JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah");
//        }
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        int i = tKrs.getSelectedRow();
        int pilihan = JOptionPane.showConfirmDialog(
            null,
            "Yakin mau hapus ?",
            "Konfirmasi hapus",
            JOptionPane.YES_NO_OPTION);
        if(pilihan==0){
            if(i>=0){
                try {
                    TableModel model = tKrs.getModel();
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    String executeQuery = "delete from krs where id=?";
                    PreparedStatement ps = con.prepareStatement(executeQuery);
                    ps.setString(1, model.getValueAt(i,0).toString());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }else{
                JOptionPane.showConfirmDialog(null, "Pilih data yang ingin dihapus");
            }
        }
        resetTable("");
    }//GEN-LAST:event_bHapusActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        resetTable("");
    }//GEN-LAST:event_bBatalActionPerformed

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
            java.util.logging.Logger.getLogger(KrsTampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KrsTampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KrsTampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KrsTampil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KrsTampil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bTutup;
    private javax.swing.JButton bUbah;
    private javax.swing.JTextField eCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tKrs;
    // End of variables declaration//GEN-END:variables
}
