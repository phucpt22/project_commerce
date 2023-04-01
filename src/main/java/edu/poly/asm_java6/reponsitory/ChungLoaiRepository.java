package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.ChungLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChungLoaiRepository extends JpaRepository<ChungLoai, Integer> {
    @Query("SELECT c.tenChungLoai FROM ChungLoai c")
    List<ChungLoai> findAllByItem2();
}