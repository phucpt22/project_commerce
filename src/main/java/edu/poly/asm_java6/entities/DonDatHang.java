package edu.poly.asm_java6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DonDatHang")
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_DDH", nullable = false)
    private int id_DDH;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDat;

    @Column(name = "ghiChuKH")
    private String ghiChuKH;

    @Column(name = "tongTien")
    private Double tongTien;

    @Column(name = "soDT", length = 15)
    private String soDT;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "trangThaiDH", nullable = false, columnDefinition = "0")
    private int trangThaiDH;


    @OneToMany(mappedBy = "donDatHang")
    private Set<DonDatChiTiet> donDatChiTiets;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_NguoiDung")
    private NguoiDung nguoiDung;
}