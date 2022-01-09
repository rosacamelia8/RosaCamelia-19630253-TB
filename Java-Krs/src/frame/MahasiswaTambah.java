package frame;

import db.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Kelas;
import model.KeyValue;
import model.Mahasiswa;

public class MahasiswaTambah extends javax.swing.JFrame {

    int status;
    Statement st; //1
    ResultSet rs;
    PreparedStatement ps;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String qryKelas = "SELECT * FROM kelas ORDER BY nama_kelas";
    
    private final int SEDANG_TAMBAH = 101;
    private final int SEDANG_UBAH = 102;  
    
public void rbJenisKelaminSetSelected(String jenisKelamin) {
    if(jenisKelamin.equals("Laki-laki"))
        rbLaki.setSelected(true);
    else
        rbPerempuan.setSelected(true);  
}

public String rbJenisKelaminGetSelected(){
    if(rbLaki.isSelected())
        return "Laki-laki";
    else if(rbPerempuan.isSelected())
        return "Perempuan";
    else
        return "";
}

public Vector getCbData(String qry, String key, String value) {
    Vector v = new Vector();
    try {
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection(); //2

        st = connection.createStatement();
        rs = st.executeQuery(qry);
        while(rs.next()){
            v.addElement(new KeyValue(rs.getInt(key), //3
                                      rs.getString(value)));
        }
    } catch (SQLException ex) {
        System.err.println("Error getData() : "+ex);
    }
    return v;
}

public void cbSetModel(String qry, String key, String value, JComboBox<String> jcb) {
    Vector v = getCbData(qry, key, value);
    DefaultComboBoxModel model;
    model = new DefaultComboBoxModel(v);
    jcb.setModel(model);
}

public void cbSetSelected(String data, JComboBox<String> cb) {
    KeyValue item = new KeyValue();
    for (int i = 0; i < cb.getItemCount(); i++)
    {
        cb.setSelectedIndex(i);
        item.setValue(((KeyValue)cb.getSelectedItem()).getValue());
        if (item.getValue().equalsIgnoreCase(data))
        {
            cb.setSelectedIndex(i);
            break;
        }
    }
}

public String makeId(){
    String id,idDate,idSem = null;
    Date now = new Date(); //3
    SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
    idDate = df.format(now);
    id = idDate+"001";
    try {
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection();

        String query = "SELECT id FROM mahasiswa where id LIKE ? "
                    + " ORDER BY id DESC";
        ps = connection.prepareStatement(query);
        ps.setString(1, idDate+"%");
        rs = ps.executeQuery();

        while(rs.next()){
            idSem = rs.getString(1);
            break;
        }
    }catch (SQLException ex) {
        System.err.println("Error makeId() : "+ex);
    }

    if (idSem!=null){
        int angka = Integer.parseInt(idSem.substring(6, 9));
        angka++;
        id=idDate+String.format("%03d", angka);
    }
    return id;
}

public Date getFormattedDate(String tanggal) {
    try {
        Date tanggalLahir = dateFormat.parse(tanggal);
        return tanggalLahir;
    }catch (ParseException ex) { //4
        System.err.println("Error Tanggal :"+ex);
        return new Date();
    }
}

    public MahasiswaTambah() {
        initComponents();
        setLocationRelativeTo(null);

        eId.setText(makeId());
        eId.setEnabled(false);
        eNamaMahasiswa.requestFocus();
        status=SEDANG_TAMBAH;
}

        public MahasiswaTambah(Mahasiswa mahasiswa) {
        initComponents();
        setLocationRelativeTo(null);
        
        eId.setText(mahasiswa.getId());
        eId.setEnabled(false);
        eNamaMahasiswa.requestFocus();
        eNamaMahasiswa.setText(mahasiswa.getNamaMahasiswa());
        rbJenisKelaminSetSelected(mahasiswa.getJenisKelamin());
        jXDatePicker1.setDate(getFormattedDate(mahasiswa.getTanggalLahir()));
        cbAgama.setSelectedItem(mahasiswa.getAgama());
        cbKelas.setSelectedItem(mahasiswa.getKelas());
        status = SEDANG_UBAH;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        eId = new javax.swing.JTextField();
        eNamaMahasiswa = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        cbAgama = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        bSimpan = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        cbKelas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DATA MAHASISWA");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(199, 201, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel1.setText("DATA MAHASISWA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel1)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel2.setText("NPM");

        jLabel3.setText("Nama Mahasiswa");

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Tanggal Lahir");

        jLabel6.setText("Agama");

        jLabel7.setText("Kelas");

        eId.setEditable(false);

        rbLaki.setText("Laki-laki");

        rbPerempuan.setText("Perempuan");

        cbAgama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Agama -", "Islam", "Kristen Protestan", "Kristen Katolik", "Hindu", "Buddha", "Kong Hu Chu" }));

        jPanel3.setBackground(new java.awt.Color(212, 222, 222));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/simpan.jpeg"))); // NOI18N
        bSimpan.setText("SIMPAN");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laporan/batal.jpeg"))); // NOI18N
        bBatal.setText("BATAL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Kelas -", "Reguler A", "Reguler B", "Reguler C", "Reguler D", "Reguler E", "Reguler F", "Reguler G", "Reguler H", "Reguler I", "Reguler J", "Reguler K", "Reguler L", "Reguler N", "Reguler O", "Non Reguler A", "Non Reguler B", "Non Reguler C", "Non Reguler D" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eNamaMahasiswa)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbAgama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eId, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbLaki)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbPerempuan)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(eId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3))
                                    .addComponent(eNamaMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbLaki)
                                .addComponent(rbPerempuan)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(eId.getText());
        mahasiswa.setNamaMahasiswa(eNamaMahasiswa.getText());
        mahasiswa.setJenisKelamin(rbJenisKelaminGetSelected());
        mahasiswa.setTanggalLahir(dateFormat.format(jXDatePicker1.getDate()));
        mahasiswa.setAgama(cbAgama.getSelectedItem().toString());
        mahasiswa.setKelas(cbKelas.getSelectedItem().toString());
             
        if(mahasiswa.getNamaMahasiswa().equalsIgnoreCase("") ||
            mahasiswa.getJenisKelamin().equalsIgnoreCase("") ||
            mahasiswa.getTanggalLahir().equalsIgnoreCase("") ||
            mahasiswa.getKelas().equalsIgnoreCase("") ||
            mahasiswa.getAgama().equalsIgnoreCase("- Pilih Agama -")) {
                JOptionPane.showMessageDialog(null, "Lengkapi data");
        }else {
        
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getConnection();
            PreparedStatement ps;
            try {
                if(status==SEDANG_TAMBAH) {
                    String qry = "insert into mahasiswa value (?,?,?,?,?,?)";
                    
                        ps = con.prepareStatement(qry);
                        ps.setString(1, mahasiswa.getId());
                        ps.setString(2, mahasiswa.getNamaMahasiswa());
                        ps.setString(3, mahasiswa.getJenisKelamin());
                        ps.setString(4, mahasiswa.getTanggalLahir());
                        ps.setString(5, mahasiswa.getAgama());
                        ps.setString(6, mahasiswa.getKelas());
                        ps.executeUpdate();
                }else {
                    String qry = "update mahasiswa set nama_mahasiswa = ?,"
                            + "jenis_kelamin = ?, tanggal_lahir = ?,"
                            + "agama = ?, kelas = ? WHERE id = ?";
                        ps = con.prepareStatement(qry);
                        ps.setString(1, mahasiswa.getNamaMahasiswa());
                        ps.setString(2, mahasiswa.getJenisKelamin());
                        ps.setString(3, mahasiswa.getTanggalLahir());
                        ps.setString(4, mahasiswa.getAgama());
                        ps.setString(5, mahasiswa.getKelas());
                        ps.setString(6, mahasiswa.getId());
                        ps.executeUpdate();         
                }
            } catch (SQLException ex) {
                System.err.println("Error Insert/Update : "+ex);
            }
            dispose();
        }
    }//GEN-LAST:event_bSimpanActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaTambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaTambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaTambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaTambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaTambah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bSimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbAgama;
    private javax.swing.JComboBox<String> cbKelas;
    private javax.swing.JTextField eId;
    private javax.swing.JTextField eNamaMahasiswa;
    private javax.swing.JFileChooser jFileChooser1;
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
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    // End of variables declaration//GEN-END:variables

    private Date getFormatedDate(String tanggalLahir) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
