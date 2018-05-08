package com.TA_2.service;

import com.TA_2.dao.PeminjamanRuanganMapper;
import com.TA_2.model.PeminjamanRuanganModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeminjamanRuanganServiceDatabase implements PeminjamanRuanganService {
    @Autowired
    private PeminjamanRuanganMapper peminjamanRuanganMapper;

    @Override
    public void addPeminjaman(PeminjamanRuanganModel peminjaman) {
        peminjamanRuanganMapper.addPeminjaman(peminjaman);
    }
}
