package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {
    @Query("SELECT c.tenchatLieu FROM ChatLieu c")
    List<ChatLieu> findAllByItem();

    @Query(value = "SELECT * FROM ChatLieu WHERE id_dm = (SELECT ID_DM FROM SanPham WHERE id_sp = ?1)", nativeQuery = true)
    ChatLieu findById_SP(int id_sp);

}