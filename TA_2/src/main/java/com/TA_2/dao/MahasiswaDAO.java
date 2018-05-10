package com.TA_2.dao;

import com.TA_2.model.MahasiswaModel;

public interface MahasiswaDAO {
    MahasiswaModel selectMahasiswaById(int id);
    MahasiswaModel selectMahasiswaByNPM(String npm);
}
