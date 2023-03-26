package edu.poly.asm_java6.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link edu.poly.asm_java6.entities.ChungLoai} entity
 */
@Data
public class ChungLoaiDto implements Serializable {
    private final Integer id_ChungLoai;
    private final String tenChungLoai;
}