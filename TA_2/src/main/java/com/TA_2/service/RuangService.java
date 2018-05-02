package com.TA_2.service;

import java.util.List;

import com.TA_2.model.RuangModel;

public interface RuangService {
	void addRuang (RuangModel ruang); 
	
	RuangModel selectRuang (Integer id_ruang);
	
	List <RuangModel> selectAllRuang();
	
	void updateRuang (RuangModel ruang);
	
	void deleteRuang (Integer id_ruang);
	
}
