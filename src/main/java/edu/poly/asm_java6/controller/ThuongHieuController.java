package edu.poly.asm_java6.controller;


import com.fasterxml.jackson.databind.util.BeanUtil;
import edu.poly.asm_java6.dto.ThuongHieuDto;
import edu.poly.asm_java6.entities.ThuongHieu;
import edu.poly.asm_java6.service.ThuongHieuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ThuongHieu")
public class ThuongHieuController {
    @Autowired
    ThuongHieuService thuongHieuService;
    @PostMapping
    public ResponseEntity<?> saveOrUpdate(@RequestBody ThuongHieuDto dto){
        ThuongHieu thuongHieu= new ThuongHieu();
        BeanUtils.copyProperties(dto, thuongHieu);
       thuongHieu = thuongHieuService.save(thuongHieu);
    dto.setId_ThuongHieu(thuongHieu.getId_ThuongHieu());

    return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
}
