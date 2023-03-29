package edu.poly.asm_java6.reponsitory;

import edu.poly.asm_java6.entities.DonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonDatHangRepository extends JpaRepository<DonDatHang, Integer> {
    @Query(value = "select TOP 1 * from DonDatHang order by Id_DDH DESC", nativeQuery = true)
    DonDatHang getIDTopLast();

//    @Query(value = "select * from DonDatHang as d join NguoiDung as nd on d.ID_KH = nd.ID_KH"
//            + " where d.TrangThai like N'Đã giao'",nativeQuery = true)
//    List<DonDatHang> done();
//
//    @Query(value = "select * from DonDatHang as d join NguoiDung as nd on d.ID_KH = nd.ID_KH"
//            + " where d.TrangThai like N'Đang giao'",nativeQuery = true)
//    List<DonDatHang> Notdone();
//    /*------------- Đơn Hàng ----------------*/
//    @Query(value = "select * from DonDatHang as d join NguoiDung as nd on d.ID_KH = nd.ID_KH"
//            + " where d.TrangThai like N'Chờ xác nhận'",nativeQuery = true)
//    List<DonDatHang> confirm();
}