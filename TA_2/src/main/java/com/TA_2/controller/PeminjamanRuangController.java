package com.TA_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    PeminjamanRuangService peminjamanruangDAO;
	

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
	
	/*@RequestMapping(value = "/ruang/update/submit")
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
	}*/
}

