package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.dto.SanPhamDto;
import edu.poly.asm_java6.entities.SanPham;
import edu.poly.asm_java6.reponsitory.SanPhamRepository;
import edu.poly.asm_java6.service.SanPhamService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository ao;

    @Override
    public List<SanPham> findAll() {
        return ao.findAll();
    }

    @Override
    public SanPham findById(Integer id) {
        return ao.findById(id).get();
    }

    @Override
    public List<SanPham> findByIDChungLoai(Integer cid) {
        return ao.findAllByIdChungLoai(cid);
    }

    @Override
    public SanPham create(SanPham SanPham) {
        return ao.save(SanPham);
    }

    @Override
    public SanPham update(SanPham SanPham) {
        return ao.save(SanPham);
    }

    @Override
    public void delete(Integer id) {
        ao.deleteById(id);
    }
}
