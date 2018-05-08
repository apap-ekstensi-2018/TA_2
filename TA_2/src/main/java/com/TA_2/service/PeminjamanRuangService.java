package com.TA_2.service;

import com.TA_2.model.PeminjamanRuangModel;

public interface PeminjamanRuangService {
	
	PeminjamanRuangModel selectPeminjamanRuang (Integer id);
	void updatePeminjamanRuang (PeminjamanRuangModel peminjaman_ruangan);

}