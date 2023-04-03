package edu.poly.asm_java6.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.poly.asm_java6.entities.DonDatChiTiet;
import edu.poly.asm_java6.entities.DonDatHang;
import edu.poly.asm_java6.reponsitory.DonDatChiTietRepository;
import edu.poly.asm_java6.reponsitory.DonDatHangRepository;
import edu.poly.asm_java6.reponsitory.NguoiDungRepository;
import edu.poly.asm_java6.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonDatHangServiceImpl implements DonHangService {

    @Autowired
    DonDatHangRepository orderDAO;
    @Autowired
    DonDatChiTietRepository orderDetailDAO;
    @Autowired
    NguoiDungRepository accountDAO;
    @Override
    public DonDatHang create(JsonNode orderData) {
        ObjectMapper mapper=new ObjectMapper();
        DonDatHang order=mapper.convertValue(orderData, DonDatHang.class);
        orderDAO.save(order);

        TypeReference<List<DonDatChiTiet>> type=new TypeReference<List<DonDatChiTiet>>(){};
        List<DonDatChiTiet> details=mapper.convertValue(orderData.get("orderDetails"), type).stream()
                .peek(d->d.setDonDatHang(order)).collect(Collectors.toList());
        orderDetailDAO.saveAll(details);
        return order;
    }

    @Override
    public DonDatHang findById(Integer id) {
        return orderDAO.findById(id).get();
    }

    @Override
    public List<DonDatHang> findByUsername(String username) {
        return orderDAO.findByUsername(username);
    }

    @Override
    public List<DonDatHang> findAll() {
        return orderDAO.findAll();
    }
}
