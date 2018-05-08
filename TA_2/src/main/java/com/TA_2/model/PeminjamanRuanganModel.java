package com.TA_2.model;

import java.util.Date;

public class PeminjamanRuanganModel {
    private int id;
    private int idRuang;
    private int idMahasiswa;
    private Date waktuMulai;
    private Date waktuSelesai;
    private Date tanggalMulai;
    private Date tanggalSelesai;
    private int kapasitas;
    private String tujuan;
    private String keterangan;
    private int jumlahPeserta;
    private String fasilitas;
    private int isDisetujui;
    private int disetujuiOleh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRuang() {
        return idRuang;
    }

    public void setIdRuang(int idRuang) {
        this.idRuang = idRuang;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public Date getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(Date waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public Date getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(Date waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public Date getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(Date tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getJumlahPeserta() {
        return jumlahPeserta;
    }

    public void setJumlahPeserta(int jumlahPeserta) {
        this.jumlahPeserta = jumlahPeserta;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public int getIsDisetujui() {
        return isDisetujui;
    }

    public void setIsDisetujui(int isDisetujui) {
        this.isDisetujui = isDisetujui;
    }

    public int getDisetujuiOleh() {
        return disetujuiOleh;
    }

    public void setDisetujuiOleh(int disetujuiOleh) {
        this.disetujuiOleh = disetujuiOleh;
    }
}
