package com.TA_2.controller;

import java.util.List;

import com.TA_2.dao.MahasiswaDAO;
import com.TA_2.dao.RuangMapper;
import com.TA_2.model.MahasiswaModel;
import com.TA_2.model.RuangModel;
import com.TA_2.service.RuangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.TA_2.model.PeminjamanRuangModel;
import com.TA_2.service.PeminjamanRuangService;

@Controller
public class PeminjamanRuangController {
	@Autowired
	PeminjamanRuangService peminjamanRuanganService;
	@Autowired
	RuangService ruangService;
	@Autowired
	MahasiswaDAO mahasiswaDAO;
	@Autowired
	RuangMapper ruangDAO;

	@RequestMapping("/peminjaman/{id}")
	public String peminjaman( Model model, @PathVariable(value = "id") int id) {
		PeminjamanRuangModel peminjaman_ruangan = peminjamanRuanganService.selectPeminjamanRuang(id);
		model.addAttribute("peminjaman_ruangan",peminjaman_ruangan);
		if (peminjaman_ruangan != null) {
			model.addAttribute ("peminjaman_ruangan", peminjaman_ruangan);
			return "view-peminjaman";
		} else {
			model.addAttribute ("id", id);
			return "not-found";
		}
	}

	@RequestMapping(value = "/peminjaman/{id}/konfirmasi/{is_disetujui}")
	public String updateStatusPeminjaman (Model model,  @ModelAttribute PeminjamanRuangModel peminjaman)
	{
		peminjamanRuanganService.updatePeminjamanRuang(peminjaman);
		model.addAttribute("title","Berhasil Ubah");
		return "konfirmasi-success";
	}

	@RequestMapping("/peminjaman/view/{id}")
	public String view( Model model, @PathVariable(value = "id") int id) {
		PeminjamanRuangModel peminjaman_ruangan = peminjamanRuanganService.selectPeminjamanRuang(id);
		
		if (peminjaman_ruangan != null) {
			MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaById(peminjaman_ruangan.getIdMahasiswa());
			peminjaman_ruangan.setIdMahasiswa(Integer.parseInt(mahasiswa.getNpm()));
			peminjaman_ruangan.setNamaMahasiswa(mahasiswa.getNama());
			
			RuangModel ruang = ruangDAO.selectRuang(peminjaman_ruangan.getIdRuang());
					
			model.addAttribute ("peminjaman_ruangan", peminjaman_ruangan);
			model.addAttribute ("ruang", ruang);
			return "view-peminjaman-ruang";
		} else {
			model.addAttribute ("id", id); return "not-found";
		}
	}

	@RequestMapping("/peminjaman/viewall")
	public String viewall(Model model) {
		List<PeminjamanRuangModel> peminjamanRuang = peminjamanRuanganService.selectPeminjamanRuangAll();
		for (PeminjamanRuangModel peminjaman: peminjamanRuang) {
			MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaById(peminjaman.getIdMahasiswa());
			peminjaman.setNamaMahasiswa(mahasiswa.getNama());
		}
		model.addAttribute("peminjamanRuang", peminjamanRuang);

		return "view-peminjaman-ruang-all";
	}

	@RequestMapping("/peminjaman/riwayat")
	public String viewmhs( Model model, @PathVariable(value = "id") int id) {
		List<PeminjamanRuangModel> peminjaman_ruangan = peminjamanRuanganService.selectPeminjamanRuangMhs(id);
		model.addAttribute("peminjaman_ruangan",peminjaman_ruangan);

		model.addAttribute ("peminjaman_ruangan", peminjaman_ruangan);
		return "view-peminjaman-ruang-mhs";

	}

	@RequestMapping("/peminjaman/tambah")
	public String add(Model model) {
		List<RuangModel> semuaRuang = ruangService.selectAllRuang();
		PeminjamanRuangModel peminjamanRuanganModel = new PeminjamanRuangModel();
		model.addAttribute("semuaRuang", semuaRuang);
		model.addAttribute("peminjamanRuangan", peminjamanRuanganModel);

		return "tambah-peminjaman";
	}

	@RequestMapping("/peminjaman/tambah/submit")
	public String addSubmit(@ModelAttribute PeminjamanRuangModel peminjaman) {
		String npm = SecurityContextHolder.getContext().getAuthentication().getName();
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByNPM(npm);

		peminjaman.setIdMahasiswa(mahasiswa.getId());
		String tanggalDanWaktuMulai = peminjaman.getTanggalMulai() + " " + peminjaman.getWaktuMulai();
		String tanggalDanWaktuSelesai = peminjaman.getTanggalSelesai() + " " + peminjaman.getWaktuSelesai();
		List<PeminjamanRuangModel> peminjamanTerpakai = peminjamanRuanganService.selectPeminjaman(tanggalDanWaktuMulai, tanggalDanWaktuSelesai, peminjaman.getIdRuang());

		if (peminjamanTerpakai.size() > 0) {
			return "tambah-peminjaman-failed-terpakai";
		} else {
			peminjamanRuanganService.addPeminjaman(peminjaman);

			return "tambah-peminjaman-success";
		}
	}
}

