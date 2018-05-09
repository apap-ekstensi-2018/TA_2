package com.TA_2.service;

import java.util.List;
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
	public void updatePeminjamanRuang(String is_disetujui, int id) {
		log.info ("update peminjamanruangan");
		peminjaman_ruanganMapper.updatePeminjamanRuang(is_disetujui,id);
	}


	@Override
	public PeminjamanRuangModel selectPeminjamanRuang2(Integer id) {
		log.info ("select peminjaman ruang dengan id {}", id);
        return peminjaman_ruanganMapper.selectPeminjamanRuang2(id);
	}


	@Override
	public List<PeminjamanRuangModel> selectPeminjamanRuangAll() {
		log.info ("select peminjaman ruang semua");
        return peminjaman_ruanganMapper.selectPeminjamanRuangAll();
	}


	@Override
	public List<PeminjamanRuangModel> selectPeminjamanRuangMhs(Integer id) {
		log.info ("select peminjaman ruang dengan id mhs {}", id);
        return peminjaman_ruanganMapper.selectPeminjamanRuangMhs(id);
	}


}