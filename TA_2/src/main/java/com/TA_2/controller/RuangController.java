package com.TA_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TA_2.model.RuangModel;
import com.TA_2.service.RuangService;


@Controller
public class RuangController {
	@Autowired
    RuangService ruangDAO;
	
	@RequestMapping("/")
    public String index ()
    {
        return "index";
    }
	
	@RequestMapping("/ruang/tambah")
    public String add ()
    {	
        return "tambah-ruang";
    }
	
	@RequestMapping("/ruang/tambah/submit")
    public String addSubmit (
    			@RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "kapasitas", required = false) int kapasitas)
    {
		RuangModel ruang = new RuangModel(nama, kapasitas);
		
		ruangDAO.addRuang (ruang);
        return "tambah-success";
    }
	
}
