package edu.poly.asm_java6.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ChatLieu} entity
 */
@Data
public class ChatLieuDto implements Serializable {
    private final Integer id_ChatLieu;
    private final String tenchatLieu;
}