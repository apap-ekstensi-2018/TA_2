package com.TA_2.dao;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 28ac9792a7745bb7bde8ceb16aa6bf3ae745b97e
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
    PeminjamanRuangModel selectPeminjamanRuang (@Param("id") Integer id);
	
	@Select("select p.*, r.nama as nama_ruang, m.npm, m.nama as nama_mahasiswa from peminjaman_ruangan p, ruang r, mahasiswa m where p.id_ruang = r.id and p.id_mahasiswa = m.id and p.id = #{id}")
    PeminjamanRuangModel selectPeminjamanRuang2 (@Param("id") Integer id);
	
	@Select("select p.*, r.nama as nama_ruang, m.npm, m.nama as nama_mahasiswa from peminjaman_ruangan p, ruang r, mahasiswa m where p.id_ruang = r.id and p.id_mahasiswa = m.id")
    List<PeminjamanRuangModel> selectPeminjamanRuangAll ();
	
	@Select("select p.*, r.nama as nama_ruang, m.npm, m.nama as nama_mahasiswa from peminjaman_ruangan p, ruang r, mahasiswa m where p.id_ruang = r.id and p.id_mahasiswa = m.id and m.id = #{id}")
    List<PeminjamanRuangModel> selectPeminjamanRuangMhs (@Param("id") Integer id);
	
	@Update("UPDATE peminjaman_ruangan SET is_disetujui = #{is_disetujui} WHERE id = #{id}")
<<<<<<< HEAD
    void updatePeminjamanRuang (@Param("is_disetujui") String is_disetujui, @Param("id") int id);
=======
    void updatePeminjamanRuang (PeminjamanRuangModel peminjaman_ruangan);
	
>>>>>>> 28ac9792a7745bb7bde8ceb16aa6bf3ae745b97e
}
