package edu.poly.asm_java6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CapQuyen",uniqueConstraints = {@UniqueConstraint(columnNames = {"id_NguoiDung","id_VaiTro"})})
public class CapQuyen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_NguoiDung")
    private NguoiDung account;
    @ManyToOne
    @JoinColumn(name = "id_VaiTro")
    private VaiTro role;

}
