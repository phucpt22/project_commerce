package edu.poly.asm_java6.service;

import com.fasterxml.jackson.databind.JsonNode;
import edu.poly.asm_java6.entities.DonDatHang;

import java.util.List;

public interface DonHangService {
    DonDatHang create(JsonNode DonDatHangData);

    DonDatHang findById(Integer id);

    List<DonDatHang> findByUsername(String username);

    List<DonDatHang> findAll();
}
