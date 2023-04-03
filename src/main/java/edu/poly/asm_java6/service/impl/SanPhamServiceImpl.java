package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.entities.SanPham;
import edu.poly.asm_java6.reponsitory.SanPhamRepository;
import edu.poly.asm_java6.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
