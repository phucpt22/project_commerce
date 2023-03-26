package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.ThuongHieu;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Long> {
    List<ThuongHieu> findByTenThuongHieuStartsWith(String tenThuongHieu, Pageable pageable);

    Optional<ThuongHieu> findByTenThuongHieu(String tenThuongHieu);

}