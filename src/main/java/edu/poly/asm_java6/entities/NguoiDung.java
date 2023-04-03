package edu.poly.asm_java6.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "NguoiDung")
public class NguoiDung implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_NguoiDung")
    private int id_NguoiDung;

    //@Column(name = "soDT", length = 15)
    //private String soDT;

    //@Column(name = "hoTen")
    private String hoTen;

    @Temporal(TemporalType.DATE)
    //@Column(name = "ngaySinh")
    private Date ngaySinh;

    //@Column(name = "gioiTinh")
    private Boolean gioiTinh;

    //@Column(name = "eMail")
    private String eMail;

    //@Column(name = "hAnh")
    private String hAnh;

    //@Column(name = "tenTK", nullable = false, unique = true, length = 50)
    private String tenTK;

    //@Column(name = "matKhau")
    private String matKhau;

    //@Column(name = "diaChi")
    private String diaChi;

    //@Column(name = "isActive", nullable = false)
    private Boolean isActive = true;

    @JsonIgnore
    @OneToMany(mappedBy ="nguoiDung" )
    private Set<DonDatHang> donDatHangs;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "account")
    List<CapQuyen> authorities;
}