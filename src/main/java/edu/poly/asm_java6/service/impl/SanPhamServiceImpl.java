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

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository dao;

    Boolean count = true;

    @Override
    public <S extends SanPham> S save(S entity) {
        return dao.save(entity);
    }

    @Override
    public List<SanPham> findAll() {
        return dao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<SanPham> findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public Page<SanPham> findAll(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return dao.findAll(pageable);
    }

    @Override
    public Page<SanPham> findByField(Integer page, Integer limit, String field, String name) {
        if (!name.isEmpty()) {
            Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC, "id"));
            return dao.findAllByNameLike(name, pageable);
        } else if (field.equals("")) {
            Pageable pageable = PageRequest.of(page, limit);
            return dao.findAll(pageable);
        } else {
            if (count) {
                count = false;
                Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.ASC, field));
                return dao.findAll(pageable);
            } else {
                count = true;
                Pageable pageable = PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, field));
                return dao.findAll(pageable);
            }
        }
    }

    @Override
    public SanPham save(SanPhamDto productModel)
            throws IllegalAccessException, InvocationTargetException, ParseException {
        SanPham SanPham = new SanPham();
        BeanUtils.copyProperties(SanPham, productModel);

        SanPham.setHAnh(productModel.getHAnh().getOriginalFilename());
        return dao.save(SanPham);
    }

    @Override
    public Page<SanPham> findAllByNameLike(String name, Pageable pageable) {
        return dao.findAllByNameLike(name, pageable);
    }
}
