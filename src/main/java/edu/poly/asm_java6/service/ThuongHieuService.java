package edu.poly.asm_java6.service;

import edu.poly.asm_java6.entities.ThuongHieu;
import edu.poly.asm_java6.reponsitory.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    //them xoa sua trong day

    public ThuongHieu save( ThuongHieu entity) {
        return thuongHieuRepository.save(entity);
    }
}
