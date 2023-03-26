package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.entities.NguoiDung;
import edu.poly.asm_java6.reponsitory.NguoiDungRepository;
import edu.poly.asm_java6.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NguoiDungServiceImpl implements NguoiDungService {
    @Autowired
    NguoiDungRepository NguoiDungRepository;

    @Override
    public List<NguoiDung> findAll() {
        return NguoiDungRepository.findAll();
    }

    @Override
    public NguoiDung findById(Integer id) {
        return NguoiDungRepository.findById(id).get();
    }

    @Override
    public NguoiDung create(NguoiDung NguoiDung) {
        return NguoiDungRepository.save(NguoiDung);
    }

    @Override
    public NguoiDung update(NguoiDung NguoiDung) {
        return NguoiDungRepository.save(NguoiDung);
    }

    @Override
    public void delete(Integer id) {
        NguoiDungRepository.deleteById(id);
    }

}
