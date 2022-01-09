
package model;

public class Krs {
    int id;
    String namaMahasiswa;
    Mahasiswa mahasiswa;
    Matakuliah matakuliah;
    String semester;
    

    public Krs() {
    }

    public Krs(int id, String namaMahasiswa, Mahasiswa mahasiswa, Matakuliah matakuliah, String semester) {
        this.id = id;
        this.namaMahasiswa = namaMahasiswa;
        this.mahasiswa = mahasiswa;
        this.matakuliah = matakuliah;
        this.semester = semester;
    }

    public Krs(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    
}
