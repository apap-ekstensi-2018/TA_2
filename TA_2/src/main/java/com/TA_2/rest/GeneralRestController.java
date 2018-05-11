package com.TA_2.rest;

import com.TA_2.model.MahasiswaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TA_2.model.RuangModel;
import com.TA_2.service.RuangService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class GeneralRestController {
	@Autowired
	RuangService ruangService;
	
	@RequestMapping("/ruang/view/{id_ruangan}")
	public RuangModel view( Model model, @PathVariable(value = "id_ruangan") Integer id_ruangan) {
		RuangModel ruang = ruangService.selectRuang(id_ruangan);
		return ruang;
	}

	@RequestMapping("/siperpus/api/{version}/isOverdue/{npm}")
	public MahasiswaModel isOverdue(@PathVariable(value = "version") String version, @PathVariable(value = "npm") String npm) {
	    MahasiswaModel mahasiswa = new MahasiswaModel();
	    mahasiswa.setNpm(npm);
		mahasiswa.setOverdue((Integer.parseInt(npm) % 2 == 0) ? false : true);

		return mahasiswa;
	}
}
