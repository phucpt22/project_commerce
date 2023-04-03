package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.CapQuyen;
import edu.poly.asm_java6.entities.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CapQuyenRepository extends JpaRepository<CapQuyen, Integer> {
    @Query("SELECT DISTINCT a FROM CapQuyen a WHERE a.account IN ?1")
    List<CapQuyen> authoritiesOf(List<NguoiDung> accounts);
}
