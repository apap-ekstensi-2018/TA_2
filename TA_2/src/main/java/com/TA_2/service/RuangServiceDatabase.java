package com.TA_2.service;

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
}
