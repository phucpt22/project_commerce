package edu.poly.asm_java6.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private int id;
	private String name;
	private String img;
	private double price;
	private int qty = 1;
}