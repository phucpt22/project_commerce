package edu.poly.asm_java6.service.impl;

import edu.poly.asm_java6.entities.DonDatChiTiet;
import edu.poly.asm_java6.reponsitory.DonDatChiTietRepository;
import edu.poly.asm_java6.service.DonHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangChiTietServiceImpl implements DonHangChiTietService {
    @Autowired
    DonDatChiTietRepository orderDetailDAO;
    @Override
    public List<DonDatChiTiet> findAll() {
        return orderDetailDAO.findAll();
    }
}
