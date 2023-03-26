package edu.poly.asm_java6.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.ThuongHieu} entity
 */
@Data
public class ThuongHieuDto implements Serializable {
    private  Long id_ThuongHieu;
    @NotEmpty(message = "Thuong hieu khong duoc de trong")
    private  String tenThuongHieu;
}