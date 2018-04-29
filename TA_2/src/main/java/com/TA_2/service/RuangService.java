package com.TA_2.service;

import java.util.List;

import com.TA_2.model.RuangModel;

public interface RuangService {
	RuangModel selectRuang (Integer id_ruang);
	
	List <RuangModel> selectAllRuang();
}
