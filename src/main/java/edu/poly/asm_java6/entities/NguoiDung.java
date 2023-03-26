package edu.poly.asm_java6.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NguoiDung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_NguoiDung", nullable = false)
    private int id_NguoiDung;

    @Column(name = "soDT", length = 15)
    private String soDT;

    @Column(name = "hoTen")
    private String hoTen;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "eMail")
    private String eMail;

    @Column(name = "hAnh")
    private String hAnh;

    @Column(name = "tenTK", nullable = false, unique = true, length = 50)
    private String tenTK;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive = true;

    @Column(name = "vaiTro", nullable = false)
    private Boolean vaiTro = false;

    @OneToMany(mappedBy ="nguoiDung" )
    private Set<DonDatHang> donDatHangs;
}