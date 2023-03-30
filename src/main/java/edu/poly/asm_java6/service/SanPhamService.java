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
    void deleteById(Integer id);

    List<SanPham> findAll();

    Optional<SanPham> findById(Integer id);

    Page<SanPham> findAll(Integer page, Integer limit);

    SanPham save(SanPhamDto productModel) throws IllegalAccessException, InvocationTargetException, ParseException;

    <S extends SanPham> S save(S entity);

    Page<SanPham> findAllByNameLike(String name, Pageable pageable);

    Page<SanPham> findByField(Integer page, Integer limit, String field, String name);
}
