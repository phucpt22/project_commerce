package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.entities.CapQuyen;
import edu.poly.asm_java6.entities.NguoiDung;
import edu.poly.asm_java6.reponsitory.CapQuyenRepository;
import edu.poly.asm_java6.service.CapQuyenService;
import edu.poly.asm_java6.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapQuyenServiceImpl implements CapQuyenService {

    @Autowired
    CapQuyenRepository authorityDAO;
    @Autowired
    NguoiDungService accountService;

    @Override
    public List<CapQuyen> findAuthoritiesOfAdministrators() {
        List<NguoiDung> accounts = accountService.getAdministrators();
        return authorityDAO.authoritiesOf(accounts);
    }

    @Override
    public List<CapQuyen> findAll() {
        return authorityDAO.findAll();
    }

    @Override
    public CapQuyen create(CapQuyen auth) {
        return authorityDAO.save(auth);
    }

    @Override
    public void delete(Integer id) {
        authorityDAO.deleteById(id);
    }
}
