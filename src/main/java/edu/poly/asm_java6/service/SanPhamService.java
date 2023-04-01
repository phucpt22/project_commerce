package edu.poly.asm_java6.service;

import edu.poly.asm_java6.dto.SanPhamDto;
import edu.poly.asm_java6.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface SanPhamService {
    List<SanPham> findAll();

    SanPham findById(Integer id);

    List<SanPham> findByIDChungLoai(Integer cid);

    SanPham create(SanPham SanPham);

    SanPham update(SanPham SanPham);

    void delete(Integer id);
}
