package edu.poly.asm_java6.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "DonDatHang")
public class DonDatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_DDH")
    private int id_DDH;

    @Temporal(TemporalType.DATE)
    private Date ngayDat;

    //@Column(name = "ghiChuKH")
    private String ghiChuKH;

    //@Column(name = "tongTien")
    private Double tongTien;

    //@Column(name = "soDT", length = 15)
    private String soDT;

    //@Column(name = "diaChi")
    private String diaChi;

    //@Column(name = "trangThaiDH", nullable = false, columnDefinition = "0")
    private int trangThaiDH;

    @JsonIgnore
    @OneToMany(mappedBy = "donDatHang")
    private List<DonDatChiTiet> donDatChiTiets;

    @ManyToOne()
    @JoinColumn(name = "id_NguoiDung")
    private NguoiDung nguoiDung;
}