package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.ChatLieu;
import edu.poly.asm_java6.entities.ThuongHieu;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Long> {
    @Query("SELECT c.tenThuongHieu FROM ThuongHieu c")
    List<ChatLieu> findAllByItem3();

}