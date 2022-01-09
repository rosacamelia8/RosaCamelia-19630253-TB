package model;

public class Matakuliah {
   private int id;
   private String kodemk;
   private String matakuliah;
   private String sks;
   private String semester;
   private String dosen;

    public Matakuliah() {
    }
    
    public Matakuliah(int id, String kodemk, String matakuliah, String sks, String dosen) {
        this.id = id;
        this.kodemk = kodemk;
        this.matakuliah = matakuliah;
        this.sks = sks;
        this.dosen = dosen;
    }

    public Matakuliah(int id, String kodemk, String matakuliah, String sks, String semester, String dosen) {
        this.id = id;
        this.kodemk = kodemk;
        this.matakuliah = matakuliah;
        this.sks = sks;
        this.semester = semester;
        this.dosen = dosen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodemk() {
        return kodemk;
    }

    public void setKodemk(String kodemk) {
        this.kodemk = kodemk;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    
}
