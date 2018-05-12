package com.TA_2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.TA_2.model.RuangModel;


@Mapper
public interface RuangMapper {
	@Insert("INSERT INTO ruang (nama, kapasitas) VALUES (#{nama}, #{kapasitas})")
    void addRuang(RuangModel ruang);
	
	@Select("select id, nama, kapasitas from ruang where id = #{id}")
    RuangModel selectRuang(@Param("id") Integer id);
	
	@Select("select id, nama,kapasitas from ruang")
	List<RuangModel> selectAllRuang();
	
	@Update("UPDATE ruang SET nama = #{nama}, kapasitas = #{kapasitas} WHERE id = #{id}")
    void updateRuang(RuangModel ruang);
	
	@Delete("DELETE FROM ruang where id = #{id}")
    void deleteRuang(@Param("id") Integer id);

	@Select("select id, nama,kapasitas from ruang where id not in (#{idRuangTerpakai})")
	List<RuangModel> selectAllRuangTersedia(String idRuangTerpakai);
	@Select("SELECT * FROM ruang WHERE id NOT IN(SELECT id_ruang FROM peminjaman_ruangan WHERE ((timestamp(tanggal_mulai, waktu_mulai) between #{tanggalDanWaktuMulai} and #{tanggalDanWaktuSelesai}) OR (timestamp(tanggal_selesai, waktu_selesai) between #{tanggalDanWaktuMulai} and #{tanggalDanWaktuSelesai})) AND is_disetujui = 1 GROUP BY id_ruang)")
	List<RuangModel> selectRuangTersedia(@Param("tanggalDanWaktuMulai") String tanggalDanWaktuMulai, @Param("tanggalDanWaktuSelesai") String tanggalDanWaktuSelesai);

	@Select("select id, nama, kapasitas from ruang where nama = #{nama}")
    RuangModel selectRuangByName(@Param("nama") String nama);
}
