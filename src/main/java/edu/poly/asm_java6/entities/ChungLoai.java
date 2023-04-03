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
@Table(name = "ChungLoai")
public class ChungLoai {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_ChungLoai")
    private Integer id_ChungLoai;

    //@Column(name = "tenChungLoai")
    private String tenChungLoai;

    @JsonIgnore
    @OneToMany(mappedBy = "chungLoai")
    private Set<SanPham> sanPhams;
}