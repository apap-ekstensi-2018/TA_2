package com.TA_2.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;


import com.TA_2.model.PeminjamanRuangModel;

public interface PeminjamanRuangService {
	PeminjamanRuangModel selectPeminjamanRuang(int id);
	PeminjamanRuangModel selectPeminjamanRuang2(int id);
	List<PeminjamanRuangModel> selectPeminjamanRuangAll();
	List<PeminjamanRuangModel> selectPeminjamanRuangMhs(int id);

	void updatePeminjamanRuang(PeminjamanRuangModel peminjaman);

	void addPeminjaman(PeminjamanRuangModel peminjaman);

	List<PeminjamanRuangModel> selectPeminjaman(String tanggalDanWaktuMulai, String tanggalDanWaktuSelesai, int idRuang);
}