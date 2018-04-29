package com.TA_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TA_2.model.RuangModel;
import com.TA_2.service.RuangService;

@Controller
public class RuangController {
	@Autowired
	private RuangService ruangDAO;
	
	@RequestMapping("/ruang/tambah")
    public String add (Model model)
    {	
		model.addAttribute ("mahasiswa", new RuangModel());
        return "tambah-ruang";
    }
	
	@RequestMapping("/")
    public String index (Model model)
    {
    	//model.addAttribute("title", "Home Page");
        return "index";
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
        model.addAttribute ("ruang", ruangs);
        return "viewall";
    }
	
}
