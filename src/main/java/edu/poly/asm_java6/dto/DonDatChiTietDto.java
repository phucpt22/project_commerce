package edu.poly.asm_java6.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.DonDatChiTiet} entity
 */
@Data
public class DonDatChiTietDto implements Serializable {
    private final Integer id_DDCT;
    private final int soLuong;
    private final String kichThuoc;
    private final Double tongTien;
}