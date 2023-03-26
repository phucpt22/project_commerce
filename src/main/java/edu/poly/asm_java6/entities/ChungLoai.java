package edu.poly.asm_java6.entities;

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
@Table(name = "ChungLoai")
public class ChungLoai {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ChungLoai", nullable = false)
    private Integer id_ChungLoai;

    @Column(name = "tenChungLoai")
    private String tenChungLoai;

    @OneToMany(mappedBy = "chungLoai")
    private Set<SanPham> sanPhams;
}