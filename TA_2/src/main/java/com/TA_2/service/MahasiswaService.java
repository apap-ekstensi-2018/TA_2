package com.TA_2.service;

import com.TA_2.model.MahasiswaModel;

public interface MahasiswaService {
    MahasiswaModel selectMahasiswaByNPM(String npm);
    MahasiswaModel selectMahasiswaById(int id);
}
