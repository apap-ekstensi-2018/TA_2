package com.TA_2.controller;

import com.TA_2.model.PeminjamanRuanganModel;
import com.TA_2.model.RuangModel;
import com.TA_2.service.PeminjamanRuanganService;
import com.TA_2.service.RuangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PeminjamanRuanganController {
    @Autowired
    RuangService ruangService;
    PeminjamanRuanganService peminjamanRuanganService;

    @RequestMapping("/peminjaman/tambah")
    public String add(Model model) {
        List<RuangModel> semuaRuang = ruangService.selectAllRuang();
        model.addAttribute("semuaRuang", semuaRuang);

        return "tambah-peminjaman-ruangan";
    }

    @RequestMapping("/peminjaman/tambah/submit")
    public String addSubmit(@ModelAttribute PeminjamanRuanganModel peminjaman) {
        peminjamanRuanganService.addPeminjaman(peminjaman);

        return "tambah-success";
    }
}
