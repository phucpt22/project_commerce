package edu.poly.asm_java6.reponsitory;


import edu.poly.asm_java6.entities.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    @Query("SELECT u FROM NguoiDung u WHERE u.tenTK = ?1")
    NguoiDung findUser(String taikhoan);
    @Query("SELECT a FROM NguoiDung a WHERE a.hoTen = ?1")
    NguoiDung findByFullname(String username);

    @Query("SELECT DISTINCT a.account FROM CapQuyen a WHERE a.role.id like '2' or a.role.id like '3'")
    List<NguoiDung> getAdministrators();
}