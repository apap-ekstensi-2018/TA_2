package com.TA_2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.TA_2.model.RuangModel;

@Mapper
public interface RuangMapper {
	@Insert("INSERT INTO ruang (nama, kapasitas) VALUES (#{nama}, #{kapasitas})")
	void addRuang (RuangModel ruang);
		
	@Select("select id, nama, kapasitas from ruang where id = #{id}")
    RuangModel selectRuang (@Param("id") Integer id);
	
	@Select("select id, nama,kapasitas from ruang")
	List <RuangModel> selectAllRuang();
}
