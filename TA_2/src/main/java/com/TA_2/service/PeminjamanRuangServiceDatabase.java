package com.TA_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TA_2.dao.PeminjamanRuangMapper;
import com.TA_2.model.PeminjamanRuangModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanRuangServiceDatabase implements PeminjamanRuangService{
	@Autowired
    private PeminjamanRuangMapper peminjaman_ruanganMapper;
	
	
	@Override
	public PeminjamanRuangModel selectPeminjamanRuang(Integer id) {
		log.info ("select ruang dengan id {}", id);
        return peminjaman_ruanganMapper.selectPeminjamanRuang(id);
	}

		
	@Override
	public void updatePeminjamanRuang(PeminjamanRuangModel peminjaman_ruangan) {
		log.info ("update peminjamanruangan");
		peminjaman_ruanganMapper.updatePeminjamanRuang(peminjaman_ruangan);
	}


}