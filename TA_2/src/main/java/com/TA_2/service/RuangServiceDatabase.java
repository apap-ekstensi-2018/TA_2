package com.TA_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TA_2.dao.RuangMapper;
import com.TA_2.model.RuangModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RuangServiceDatabase implements RuangService{
	@Autowired 
	private RuangMapper ruangMapper;
	
	@Override
	public void addRuang(RuangModel ruang) {
		log.info ("insert ruang");
		ruangMapper.addRuang(ruang);
	}
	
	@Override
	public RuangModel selectRuang(Integer id_ruang) {
		log.info ("select ruang dengan id {}", id_ruang);
        return ruangMapper.selectRuang(id_ruang);
	}

	@Override
	public List<RuangModel> selectAllRuang() {
		log.info("select all ruang");
		return ruangMapper.selectAllRuang();
	}

}
