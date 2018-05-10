package com.TA_2.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TA_2.dao.PeminjamanRuangMapper;
import com.TA_2.model.PeminjamanRuangModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanRuangServiceDatabase implements PeminjamanRuangService {
	@Autowired
    private PeminjamanRuangMapper peminjamanRuangMapper;

	@Override
	public PeminjamanRuangModel selectPeminjamanRuang(int id) {
		//log.info ("select ruang dengan id {}", id);
        return peminjamanRuangMapper.selectPeminjamanRuang(id);
	}

	@Override
	public PeminjamanRuangModel selectPeminjamanRuang2(int id) {
		//log.info ("select peminjaman ruang dengan id {}", id);
		return peminjamanRuangMapper.selectPeminjamanRuang2(id);
	}

	@Override
	public List<PeminjamanRuangModel> selectPeminjamanRuangAll() {
		//log.info ("select peminjaman ruang semua");
		return peminjamanRuangMapper.selectPeminjamanRuangAll();
	}

	@Override
	public List<PeminjamanRuangModel> selectPeminjamanRuangMhs(int id) {
		//log.info ("select peminjaman ruang dengan id mhs {}", id);
		return peminjamanRuangMapper.selectPeminjamanRuangMhs(id);
	}

	@Override
	public void updatePeminjamanRuang(PeminjamanRuangModel peminjaman) {
		//log.info ("update peminjamanruangan");
		peminjamanRuangMapper.updatePeminjamanRuang(peminjaman);
	}

	@Override
	public void addPeminjaman(PeminjamanRuangModel peminjaman) {
		peminjamanRuangMapper.addPeminjaman(peminjaman);
	}

	@Override
	public List<PeminjamanRuangModel> selectPeminjaman(String tanggalDanWaktuMulai, String tanggalDanWaktuSelesai, int idRuang) {
		return peminjamanRuangMapper.selectPeminjaman(tanggalDanWaktuMulai, tanggalDanWaktuSelesai, idRuang);
	}
}