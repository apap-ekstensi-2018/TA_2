package com.TA_2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TA_2.model.RuangModel;
import com.TA_2.service.RuangService;

@RestController
@RequestMapping("/rest")
public class RuanganRestController {
	@Autowired
	RuangService ruangService;
	
	@RequestMapping("/ruang/view/{id_ruangan}")
	public RuangModel view( Model model, @PathVariable(value = "id_ruangan") Integer id_ruangan) {
		RuangModel ruang = ruangService.selectRuang(id_ruangan);
		return ruang;
	}
	
}
