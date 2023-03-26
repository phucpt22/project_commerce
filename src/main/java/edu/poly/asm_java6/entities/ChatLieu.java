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
@Table(name = "ChatLieu")
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ChatLieu", nullable = false)
    private Integer id_ChatLieu;

    @Column(name = "tenchatLieu")
    private String tenchatLieu;

    @OneToMany(mappedBy = "chatLieu")
    private Set<SanPham> sanPhams;
}