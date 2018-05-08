package com.TA_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TA_2.model.PeminjamanRuangModel;
import com.TA_2.model.RuangModel;
import com.TA_2.service.PeminjamanRuangService;
import com.TA_2.service.RuangService;

@Controller
public class RuangController {
	@Autowired
    RuangService ruangDAO;
	@Autowired
    PeminjamanRuangService peminjamanruangDAO;

	
	@RequestMapping("/ruang/tambah")
    public String add ()
    {	
        return "tambah-ruang";
    }
	
	@RequestMapping("/ruang/tambah/submit")
    public String addSubmit (@ModelAttribute RuangModel ruang)
    {
		ruangDAO.addRuang (ruang);
        return "tambah-success";
    }

	
	@RequestMapping("/ruang/view/{id_ruangan}")
	public String view( Model model, @PathVariable(value = "id_ruangan") Integer id_ruangan) {
		RuangModel ruang = ruangDAO.selectRuang(id_ruangan);
		model.addAttribute("ruang",ruang);
		if (ruang != null) {
            model.addAttribute ("ruang", ruang);
            return "view-ruang";
        } else {
            model.addAttribute ("id", id_ruangan);
            return "not-found";
        }
	}
	

	@RequestMapping("ruang/viewall")
	public String view (Model model)
    {
        List<RuangModel> ruangs = ruangDAO.selectAllRuang();
        model.addAttribute ("ruangs", ruangs);
        return "viewall";
    }
	
	@RequestMapping("/ruang/update/{id_ruangan}")
    public String update (Model model, @PathVariable(value = "id_ruangan") Integer id_ruangan)
    {	
		RuangModel ruang = ruangDAO.selectRuang(id_ruangan);
		model.addAttribute("ruang",ruang);
		if (ruang != null) {
            model.addAttribute ("ruang", ruang);
            return "update-ruang";
        } else {
            model.addAttribute ("id", id_ruangan);
            return "not-found";
        }
    }
	
	@RequestMapping(value = "/ruang/update/submit")
    public String updateSubmit (@ModelAttribute RuangModel ruang, Model model)
    {
		ruangDAO.updateRuang(ruang);
		//model.addAttribute ("ruang", ruang);
        return "update-success";
    }
	
	@RequestMapping("/ruang/delete/{id_ruangan}")
	public String delete (Model model, @PathVariable(value = "id_ruangan") Integer id_ruangan)
	{   
		RuangModel ruang = ruangDAO.selectRuang(id_ruangan);
	    if (ruang != null) {
	    	ruangDAO.deleteRuang (id_ruangan);
	        model.addAttribute ("ruang", ruang);
	        return "delete";
	    } else {
	    	model.addAttribute ("id_ruangan", id_ruangan);
	        return "not-found";
	    }
	}
	
	@RequestMapping("/peminjaman/{id}")
	public String peminjaman( Model model, @PathVariable(value = "id") Integer id) {
		PeminjamanRuangModel peminjaman_ruangan = peminjamanruangDAO.selectPeminjamanRuang(id);
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
}

