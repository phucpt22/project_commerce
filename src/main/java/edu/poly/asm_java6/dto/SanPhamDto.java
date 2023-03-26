package edu.poly.asm_java6.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.SanPham} entity
 */
@Data
public class SanPhamDto implements Serializable {
    private final Long id_SP;
    private final String tenSP;
    private final String hAnh;
    private final String moTa;
    private final Boolean is_Delete;
    private final Boolean trangThai;
    private final Double gia;
    private final int slTonKho;
}