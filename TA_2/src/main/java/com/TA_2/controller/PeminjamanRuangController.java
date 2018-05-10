package com.TA_2.controller;

import java.util.*;

import com.TA_2.dao.MahasiswaDAO;
import com.TA_2.dao.RuangMapper;
import com.TA_2.model.MahasiswaModel;
import com.TA_2.model.RuangModel;
import com.TA_2.service.RuangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Autowired
    PeminjamanRuangService peminjamanruangDAO;


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

	@RequestMapping(value = "/peminjaman/{id}/konfirmasi", method = RequestMethod.POST)
    public String updateStatusPeminjaman (Model model,  @PathVariable(value = "id") Integer id, @ModelAttribute PeminjamanRuangModel peminjaman_ruangan)
    {	
		peminjamanruangDAO.updatePeminjamanRuang(peminjaman_ruangan);
		 model.addAttribute("peminjaman_ruangan", peminjaman_ruangan);
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
			peminjaman_ruangan.setNamaRuang(ruang.getNama());
					
			model.addAttribute ("peminjaman_ruangan", peminjaman_ruangan);
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
			
			RuangModel ruang = ruangDAO.selectRuang(peminjaman.getIdRuang());
			peminjaman.setNamaRuang(ruang.getNama());
		}
		model.addAttribute("peminjamanRuang", peminjamanRuang);

		return "view-peminjaman-ruang-all";
	}

	@RequestMapping("/peminjaman/riwayat")
	public String viewmhs( Model model) {
		String npm = SecurityContextHolder.getContext().getAuthentication().getName();
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByNPM(npm);
		
		List<PeminjamanRuangModel> peminjamanRuangan = peminjamanRuanganService.selectPeminjamanRuangMhs(mahasiswa.getId());
		for (PeminjamanRuangModel peminjaman: peminjamanRuangan) {
			mahasiswa = mahasiswaDAO.selectMahasiswaById(peminjaman.getIdMahasiswa());
			peminjaman.setNamaMahasiswa(mahasiswa.getNama());
			
			RuangModel ruang = ruangDAO.selectRuang(peminjaman.getIdRuang());
			peminjaman.setNamaRuang(ruang.getNama());
		}
		
		model.addAttribute("peminjamanRuang",peminjamanRuangan);
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
	public String addSubmit(Model model, @ModelAttribute PeminjamanRuangModel peminjaman) {
		List<PeminjamanRuangModel> peminjamanTerpakai = peminjamanRuanganService.selectPeminjaman(peminjaman.getTanggalMulai(), peminjaman.getTanggalSelesai(), peminjaman.getIdRuang());

		if (peminjamanTerpakai.size() > 0) {
		    model.addAttribute("pesanGagal", "Gagal mengajukan peminjaman ruangan karena ruangan telah dipakai untuk jangka waktu yang anda masukkan.");

			return "tambah-peminjaman-failed";
		} else {
			String npm = SecurityContextHolder.getContext().getAuthentication().getName();
			MahasiswaModel mahasiswaOverdueStatus = mahasiswaDAO.getOverdueStatus(npm);

			if (mahasiswaOverdueStatus.getOverdue() == true) {
				model.addAttribute("pesanGagal", "Gagal mengajukan peminjaman ruangan karena anda masih mememiliki buku yang belum dikembalikan ke SIPERPUS.");

				return "tambah-peminjaman-failed";
			} else {
				MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswaByNPM(npm);
				peminjaman.setIdMahasiswa(mahasiswa.getId());

				String[] splitTanggalMulai = peminjaman.getTanggalMulai().split(" ");
				String[] splitTanggalSelesai = peminjaman.getTanggalSelesai().split(" ");
				peminjaman.setTanggalMulai(splitTanggalMulai[0]);
				peminjaman.setWaktuMulai(splitTanggalMulai[1]);
				peminjaman.setTanggalSelesai(splitTanggalSelesai[0]);
				peminjaman.setWaktuSelesai(splitTanggalSelesai[1]);

				peminjamanRuanganService.addPeminjaman(peminjaman);

				return "tambah-peminjaman-success";
			}
		}
	}

	@RequestMapping("/peminjaman/tersedia")
	public String getTersedia( Model model, @RequestParam(value = "tanggal_awal", required = false) String tanggalAwal, @RequestParam(value = "tanggal_selesai", required = false) String tanggalSelesai) {
		List<RuangModel> ruangTersedia = new ArrayList<RuangModel>();

	    if (tanggalAwal != null && tanggalSelesai != null) {
	        model.addAttribute("tanggalAwal", tanggalAwal);
			model.addAttribute("tanggalSelesai", tanggalSelesai);

			ruangTersedia = ruangDAO.selectRuangTersedia(tanggalAwal, tanggalSelesai);
		}

		model.addAttribute("ruangTersedia", ruangTersedia);

		return "view-ruang-tersedia";
	}
}

