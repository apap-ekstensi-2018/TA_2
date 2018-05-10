package com.TA_2.dao;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.TA_2.model.PeminjamanRuangModel;

@Mapper
public interface PeminjamanRuangMapper {
	@Select("select * from peminjaman_ruangan where id = #{id}")
    PeminjamanRuangModel selectPeminjamanRuang(@Param("id") int id);

	@Select("select p.*, r.nama as nama_ruang, m.npm, m.nama as nama_mahasiswa from peminjaman_ruangan p, ruang r, mahasiswa m where p.id_ruang = r.id and p.id_mahasiswa = m.id and p.id = #{id}")
    PeminjamanRuangModel selectPeminjamanRuang2(@Param("id") int id);

	@Select("select * from peminjaman_ruangan")
    List<PeminjamanRuangModel> selectPeminjamanRuangAll();

	@Select("select * from peminjaman_ruangan where id_mahasiswa = #{id}")
    List<PeminjamanRuangModel> selectPeminjamanRuangMhs(@Param("id") int id);

	@Update("UPDATE peminjaman_ruangan SET is_disetujui = #{isDisetujui} WHERE id = #{id}")
    void updatePeminjamanRuang(PeminjamanRuangModel peminjaman);

    @Insert("INSERT INTO peminjaman_ruangan(id_ruang, id_mahasiswa, waktu_mulai, waktu_selesai, tanggal_mulai, tanggal_selesai, kapasitas, tujuan, keterangan, jumlah_peserta, fasilitas, is_disetujui, disetujui_oleh) VALUES (#{idRuang}, #{idMahasiswa}, #{waktuMulai}, #{waktuSelesai}, #{tanggalMulai}, #{tanggalSelesai}, #{kapasitas}, #{tujuan}, #{keterangan}, #{jumlahPeserta}, #{fasilitas}, null, null)")
    void addPeminjaman(PeminjamanRuangModel peminjaman);

    @Select("SELECT * FROM peminjaman_ruangan WHERE ((timestamp(tanggal_mulai, waktu_mulai) between #{tanggalDanWaktuMulai} and #{tanggalDanWaktuSelesai}) OR (timestamp(tanggal_selesai, waktu_selesai) between #{tanggalDanWaktuMulai} and #{tanggalDanWaktuSelesai})) AND id_ruang = #{idRuang} AND is_disetujui = 1")
    List<PeminjamanRuangModel> selectPeminjaman(@Param("tanggalDanWaktuMulai") String tanggalDanWaktuMulai, @Param("tanggalDanWaktuSelesai") String tanggalDanWaktuSelesai, @Param("idRuang") int idRuang);
}
