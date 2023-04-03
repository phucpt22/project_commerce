package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.entities.ChungLoai;
import edu.poly.asm_java6.reponsitory.ChungLoaiRepository;
import edu.poly.asm_java6.service.ChungLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChungLoaiServiceImpl implements ChungLoaiService {


    @Autowired
    ChungLoaiRepository categoryDAO;
    @Override
    public List<ChungLoai> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public ChungLoai findById(Integer id) {
        return categoryDAO.findById(id).get();
    }

    @Override
    public ChungLoai create(ChungLoai ChungLoai) {
        return categoryDAO.save(ChungLoai);
    }

    @Override
    public ChungLoai update(ChungLoai ChungLoai) {
        return categoryDAO.save(ChungLoai);
    }

    @Override
    public void delete(Integer id) {
        categoryDAO.deleteById(id);
    }
}
