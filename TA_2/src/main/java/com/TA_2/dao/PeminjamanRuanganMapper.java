package com.TA_2.dao;

import com.TA_2.model.PeminjamanRuanganModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PeminjamanRuanganMapper {
    @Insert("INSERT INTO peminjaman_ruangan(id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, kapasitas, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui, disetujui_oleh) VALUES (#{idRuang}, #{idMahasiswa}, #{waktuMulai}, #{waktuSelesai}, #{tanggalMulai}, #{tanggalSelesai}, #{kapasitas}, #{tujuan}, #{keterangan}, #{jumlahPeserta}, #{fasilitas}, null, null)")
    void addPeminjaman(PeminjamanRuanganModel peminjaman);

    @Select("SELECT * FROM peminjaman_ruangan WHERE ((timestamp(tanggal_mulai, waktu_mulai) between #{tanggalDanWaktuMulai} and #{tanggalDanWaktuSelesai}) OR (timestamp(tanggal_selesai, waktu_selesai) between #{tanggalDanWaktuMulai} and #{tanggalDanWaktuSelesai})) AND id_ruang = #{idRuang} AND is_disetujui = 1")
    List<PeminjamanRuanganModel> selectPeminjaman(@Param("tanggalDanWaktuMulai") String tanggalDanWaktuMulai, @Param("tanggalDanWaktuSelesai") String tanggalDanWaktuSelesai, @Param("idRuang") int idRuang);
}
