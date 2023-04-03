package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.ChungLoai;

import java.util.List;

public interface ChungLoaiService {
    List<ChungLoai> findAll();

    ChungLoai findById(Integer id);

    ChungLoai create(ChungLoai ChungLoai);

    ChungLoai update(ChungLoai ChungLoai);

    void delete(Integer id);

}
