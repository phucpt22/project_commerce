package edu.poly.asm_java6.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.NguoiDung} entity
 */
@Data
public class NguoiDungDto implements Serializable {
    private final int id_NguoiDung;
    private final String soDT;
    private final String hoTen;
    private final Date ngaySinh;
    private final Boolean gioiTinh;
    private final String eMail;
    private final String hAnh;
    private final String tenTK;
    private final String matKhau;
    private final String diaChi;
    private final Boolean isActive;
    private final Boolean vaiTro;
}