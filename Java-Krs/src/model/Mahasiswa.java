package model;

public class Mahasiswa {
    String id;
    String namaMahasiswa;
    String jenisKelamin;
    String tanggalLahir;
    String agama;
    String kelas;

    public Mahasiswa() {
    }
    
    public Mahasiswa(String id,String namaMahasiswa,String kelas) {
        this.id = id;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
    }

    public Mahasiswa(String id, String namaMahasiswa, String jenisKelamin, String tanggalLahir, String agama, String kelas) {
        this.id = id;
        this.namaMahasiswa = namaMahasiswa;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
        this.agama = agama;
        this.kelas = kelas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

}
