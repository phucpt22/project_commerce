package edu.poly.asm_java6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ThuongHieu")
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ThuongHieu", nullable = false)
    private Long id_ThuongHieu;

    @Column(name = "tenThuongHieu")
    private String tenThuongHieu;
    @OneToMany(mappedBy = "thuongHieu")
    private Set<SanPham> sanPham;
}