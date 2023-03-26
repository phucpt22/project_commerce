package edu.poly.asm_java6.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.ThuongHieu} entity
 */
@Data
public class ThuongHieuDto implements Serializable {
    private  Long id_ThuongHieu;
    private  String tenThuongHieu;
}