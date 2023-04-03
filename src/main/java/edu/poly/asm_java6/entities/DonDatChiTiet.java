package edu.poly.asm_java6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DonDatChiTiet")
public class DonDatChiTiet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_DDCT", nullable = false)
    private Integer id_DDCT;

    //@Column(name = "soLuong")
    private int soLuong;

    //@Column(name = "kichThuoc", length = 15)
    private String kichThuoc;

    //@Column(name = "tongTien")
    private Double tongTien;
    @ManyToOne()
    @JoinColumn(name = "id_DDH")
    DonDatHang donDatHang;

    @ManyToOne()
    @JoinColumn(name = "id_SP")
    SanPham sanPham;


}