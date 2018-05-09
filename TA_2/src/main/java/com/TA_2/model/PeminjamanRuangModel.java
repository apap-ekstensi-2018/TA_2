package com.TA_2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeminjamanRuangModel {
	private int id;
	private int id_ruang;
	private int id_mahasiswa;
	private String waktu_mulai;
	private String waktu_selesai;
	private String tanggal_mulai;
	private String tanggal_selesai;
	private int kapasitas;
	private String tujuan;
	private String keterangan;
	private int jumlah_peserta;
	private String fasilitas;
	private String is_disetujui;
	private String disetujui_oleh;
	private String npm;
	private String nama_mahasiswa;
	private String nama_ruang;
}
