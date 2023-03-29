package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    //@Query("SELECT u FROM SanPham u")
    List<SanPham> findAllByTenSPLike(String tensp); //sử dụng DSL
    List<SanPham> findAllByChatLieuLike(String chatlieu);
    List<SanPham> findAllByChungLoaiLike(String chungloai);
    List<SanPham> findAllByThuongHieuLike(String thuonghieu);

}