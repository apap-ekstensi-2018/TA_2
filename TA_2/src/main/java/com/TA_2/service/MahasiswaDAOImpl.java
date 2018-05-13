package com.TA_2.service;

import com.TA_2.config.ApiCall;
import com.TA_2.dao.MahasiswaDAO;
import com.TA_2.model.MahasiswaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MahasiswaDAOImpl implements MahasiswaDAO {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MahasiswaModel selectMahasiswaByNPM(String npm) {
        MahasiswaModel mahasiswaModel = restTemplate.getForObject(ApiCall.APAP_EKSTENSI_API_BASE_URL + "/mahasiswa/view/npm/" + npm, MahasiswaModel.class);

        return mahasiswaModel;
    }

    @Override
    public MahasiswaModel selectMahasiswaById(int id) {
        MahasiswaModel mahasiswaModel = restTemplate.getForObject(ApiCall.APAP_EKSTENSI_API_BASE_URL + "/mahasiswa/view/id/" + id, MahasiswaModel.class);

        return mahasiswaModel;
    }

    @Override
    public MahasiswaModel getOverdueStatus(String npm) {
        String url = ApiCall.SIPERPUS_API_BASE_URL + "/json/isOverdue/" + npm;
        MahasiswaModel mahasiswaModel = restTemplate.getForObject(url, MahasiswaModel.class);

        return mahasiswaModel;
    }
}
