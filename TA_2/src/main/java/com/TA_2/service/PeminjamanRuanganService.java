package com.TA_2.service;

import com.TA_2.model.PeminjamanRuanganModel;

import java.util.List;

public interface PeminjamanRuanganService {
    void addPeminjaman(PeminjamanRuanganModel peminjaman);

    List<PeminjamanRuanganModel> selectPeminjaman(String tanggalDanWaktuMulai, String tanggalDanWaktuSelesai, int idRuang);
}
