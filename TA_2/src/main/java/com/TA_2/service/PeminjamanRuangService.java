package com.TA_2.service;

import java.util.List;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
=======

>>>>>>> 28ac9792a7745bb7bde8ceb16aa6bf3ae745b97e
import com.TA_2.model.PeminjamanRuangModel;

public interface PeminjamanRuangService {
	
	PeminjamanRuangModel selectPeminjamanRuang (Integer id);
	PeminjamanRuangModel selectPeminjamanRuang2 (Integer id);
	List<PeminjamanRuangModel> selectPeminjamanRuangAll ();
	List<PeminjamanRuangModel> selectPeminjamanRuangMhs (Integer id);
<<<<<<< HEAD
	void updatePeminjamanRuang (String is_disetujui, int id);
=======
	void updatePeminjamanRuang (PeminjamanRuangModel peminjaman_ruangan);

>>>>>>> 28ac9792a7745bb7bde8ceb16aa6bf3ae745b97e
}