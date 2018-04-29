package com.TA_2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuangModel {
	private int id;
	private String nama;
	private int kapasitas;
}