package com.TA_2.dao;

import com.TA_2.model.PeminjamanRuanganModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeminjamanRuanganMapper {
    @Insert("INSERT INTO peminjaman_ruangan(id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, kapasitas, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui, disetujui_oleh) VALUES (#{id_ruang}, #{id_mahasiswa}, #{waktu_mulai}, #{waktu_selesai}, #{tanggal_mulai}, #{tanggal_selesai}, #{kapasitas}, #{tujuan}, #{keterangan}, #{jumlah_peserta}, #{fasilitas}, #{is_disetujui}, #{disetujui_oleh})")
    void addPeminjaman(PeminjamanRuanganModel peminjaman);
}
