package com.TA_2.service;

import com.TA_2.dao.MahasiswaDAO;
import com.TA_2.model.MahasiswaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MahasiswaServiceRest implements MahasiswaService {
    @Autowired
    private MahasiswaDAO mahasiswaDAO;

    @Override
    public MahasiswaModel selectMahasiswa(String npm) {
        return mahasiswaDAO.selectMahasiswa(npm);
    }
}
