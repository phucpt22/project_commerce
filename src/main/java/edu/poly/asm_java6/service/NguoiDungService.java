package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.NguoiDung;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDung> findAll();

    NguoiDung findById(Integer id);

    NguoiDung create(NguoiDung NguoiDung);

    NguoiDung update(NguoiDung NguoiDung);

    void delete(Integer id);

}
