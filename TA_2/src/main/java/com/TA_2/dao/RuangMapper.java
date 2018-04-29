package com.TA_2.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.TA_2.model.RuangModel;


@Mapper
public interface RuangMapper {
	@Insert("INSERT INTO ruang (nama, kapasitas) VALUES (#{nama}, #{kapasitas})")
    void addRuang (RuangModel ruang);
	
}
