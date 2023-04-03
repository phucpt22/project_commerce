package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.entities.VaiTro;
import edu.poly.asm_java6.reponsitory.VaiTroReponsitory;
import edu.poly.asm_java6.service.VaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VaiTroServiceImpl implements VaiTroService {
    @Autowired
    VaiTroReponsitory roleDAO;
    @Override
    public List<VaiTro> findAll() {
        return roleDAO.findAll();
    }
}
