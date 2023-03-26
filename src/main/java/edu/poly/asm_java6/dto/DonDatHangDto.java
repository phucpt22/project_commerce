package edu.poly.asm_java6.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.DonDatHang} entity
 */
@Data
public class DonDatHangDto implements Serializable {
    private final int id_DDH;
    private final Date ngayDat;
    private final String ghiChuKH;
    private final Double tongTien;
    private final String soDT;
    private final String diaChi;
    private final int trangThaiDH;
}