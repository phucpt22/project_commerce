package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.DonDatChiTiet;

import java.util.List;

public interface DonHangChiTietService {
    List<DonDatChiTiet> findAll();
}
