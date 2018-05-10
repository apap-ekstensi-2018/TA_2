package com.TA_2.controller;

import com.TA_2.config.ApiCall;
import com.TA_2.dao.MahasiswaDAO;
import com.TA_2.model.MahasiswaModel;
import com.TA_2.model.PeminjamanRuanganModel;
import com.TA_2.model.RuangModel;
import com.TA_2.service.PeminjamanRuanganService;
import com.TA_2.service.RuangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class PeminjamanRuanganController {
    @Autowired
    PeminjamanRuanganService peminjamanRuanganService;
    @Autowired
    RuangService ruangService;
    @Autowired
    MahasiswaDAO mahasiswaDAO;

    @RequestMapping("/peminjaman/tambah")
    public String add(Model model) {
        List<RuangModel> semuaRuang = ruangService.selectAllRuang();
        PeminjamanRuanganModel peminjamanRuanganModel = new PeminjamanRuanganModel();
        model.addAttribute("semuaRuang", semuaRuang);
        model.addAttribute("peminjamanRuangan", peminjamanRuanganModel);

        return "tambah-peminjaman";
    }

    @RequestMapping("/peminjaman/tambah/submit")
    public String addSubmit(@ModelAttribute PeminjamanRuanganModel peminjaman) {
        String npm = SecurityContextHolder.getContext().getAuthentication().getName();
        MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);

        peminjaman.setIdMahasiswa(mahasiswa.getId());
        String tanggalDanWaktuMulai = peminjaman.getTanggalMulai() + " " + peminjaman.getWaktuMulai();
        String tanggalDanWaktuSelesai = peminjaman.getTanggalSelesai() + " " + peminjaman.getWaktuSelesai();
        List<PeminjamanRuanganModel> peminjamanTerpakai = peminjamanRuanganService.selectPeminjaman(tanggalDanWaktuMulai, tanggalDanWaktuSelesai, peminjaman.getIdRuang());

        if (peminjamanTerpakai.size() > 0) {
            return "tambah-peminjaman-failed-terpakai";
        } else {
            peminjamanRuanganService.addPeminjaman(peminjaman);

            return "tambah-peminjaman-success";
        }
    }
}
