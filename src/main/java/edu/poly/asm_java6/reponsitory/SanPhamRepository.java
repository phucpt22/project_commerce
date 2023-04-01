package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    //@Query("SELECT u FROM SanPham u")
    List<SanPham> findAllByTenSPLike(String tensp); //sử dụng DSL
    @Query("SELECT u FROM SanPham u where u.chungLoai.id_ChungLoai = ?1")
    List<SanPham> findAllByIdChungLoai(Integer chungloai);
    @Query("SELECT count(p.id_SP) FROM SanPham p")
    Integer countAllProduct();
}