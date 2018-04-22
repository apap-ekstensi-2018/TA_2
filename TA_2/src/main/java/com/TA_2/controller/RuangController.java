package com.TA_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TA_2.model.RuangModel;

@Controller
public class RuangController {
	@RequestMapping("/ruang/tambah")
    public String add (Model model)
    {	
		model.addAttribute ("mahasiswa", new RuangModel());
        return "tambah-ruang";
    }
}
