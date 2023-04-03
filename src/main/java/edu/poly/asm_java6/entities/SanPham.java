package edu.poly.asm_java6.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_SP", nullable = false)
    private Integer id_SP;

    //@Column
    private String tenSP,hAnh,moTa;

    //@Column(name = "is_Delete", columnDefinition = "true")
    private Boolean is_Delete;
    //@Column(name = "trangThai", columnDefinition = "true")
    private Boolean trangThai;

    //@Column(name = "gia")
    private Double gia;

    //@Column(name = "slTonKho", nullable = false)
    private int slTonKho;

    @ManyToOne()
    @JoinColumn(name = "id_ChungLoai")
    private ChungLoai chungLoai;

    @JsonIgnore
    @OneToMany(mappedBy = "sanPham")
    private Set<DonDatChiTiet> donDatChiTiets;
}