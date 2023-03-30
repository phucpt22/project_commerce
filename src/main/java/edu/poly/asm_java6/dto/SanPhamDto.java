package edu.poly.asm_java6.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.SanPham} entity
 */
@Data

public class SanPhamDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_SP;
    @NotEmpty(message = "Không được để trống!")
    @Length(min = 5, max = 50, message = "Phải có từ 5 - 50  ký tự!")
    private  String tenSP;
    private  MultipartFile hAnh;
    @NotEmpty(message = "Không được để trống!")
    @Length(min = 5, max = 50, message = "Phải có từ 5 - 50  ký tự!")
    private  String moTa;
    private  Boolean is_Delete;
    private  Boolean trangThai;
    @NotNull(message = "Không được để trống!")
    private  Double gia;
    @NotNull(message = "Không được để trống!")
    private  int slTonKho;
}