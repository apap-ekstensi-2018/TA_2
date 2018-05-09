package com.TA_2.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;


import com.TA_2.model.PeminjamanRuangModel;

public interface PeminjamanRuangService {
	
	PeminjamanRuangModel selectPeminjamanRuang (Integer id);
	PeminjamanRuangModel selectPeminjamanRuang2 (Integer id);
	List<PeminjamanRuangModel> selectPeminjamanRuangAll ();
	List<PeminjamanRuangModel> selectPeminjamanRuangMhs (Integer id);

	void updatePeminjamanRuang (PeminjamanRuangModel peminjaman_ruangan);

}