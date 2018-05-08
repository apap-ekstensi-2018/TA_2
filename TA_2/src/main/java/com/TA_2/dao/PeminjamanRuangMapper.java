package com.TA_2.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.TA_2.model.PeminjamanRuangModel;


@Mapper
public interface PeminjamanRuangMapper {

	@Select("select id, tanggal_mulai, tanggal_selesai, waktu_mulai, waktu_selesai, is_disetujui from peminjaman_ruangan where id = #{id}")
    PeminjamanRuangModel selectPeminjamanRuang (@Param("id") Integer id);
	
	@Update("UPDATE peminjaman_ruangan SET is_disetujui = #{is_disetujui} WHERE id = #{id}")
    void updatePeminjamanRuang (PeminjamanRuangModel peminjaman_ruangan);
}
