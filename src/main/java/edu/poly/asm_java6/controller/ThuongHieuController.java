package edu.poly.asm_java6.controller;


import edu.poly.asm_java6.dto.ThuongHieuDto;
import edu.poly.asm_java6.entities.ThuongHieu;
import edu.poly.asm_java6.service.MapValidationErrorsService;
import edu.poly.asm_java6.service.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ThuongHieu")
public class ThuongHieuController {
    @Autowired
    ThuongHieuService thuongHieuService;

    @Autowired
    MapValidationErrorsService mapValidationErrorsService;
    @PostMapping
    public ResponseEntity<?> CreateThuongHieu(@Valid @RequestBody ThuongHieuDto dto, BindingResult result){

       ResponseEntity<?> responseEntity= mapValidationErrorsService.mapValidationFields(result);

       if (responseEntity != null){
          return responseEntity;
       }
        ThuongHieu thuongHieu= new ThuongHieu();
        BeanUtils.copyProperties(dto, thuongHieu);
       thuongHieu = thuongHieuService.save(thuongHieu);
    dto.setId_ThuongHieu(thuongHieu.getId_ThuongHieu());

    return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> UpdateThuongHieu( @PathVariable("id") Long id,
                                        @RequestBody ThuongHieuDto dto){
        ThuongHieu thuongHieu= new ThuongHieu();
        BeanUtils.copyProperties(dto, thuongHieu);
        thuongHieu = thuongHieuService.save(thuongHieu);
        dto.setId_ThuongHieu(thuongHieu.getId_ThuongHieu());

        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
}
