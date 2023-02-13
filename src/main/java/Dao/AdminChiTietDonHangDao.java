
package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.AdminChiTietDonHangBean;



public class AdminChiTietDonHangDao {

  public ArrayList<AdminChiTietDonHangBean> getdanhsach(long mahoadon) {
    ArrayList<AdminChiTietDonHangBean> ds = new ArrayList<AdminChiTietDonHangBean>();
    try {
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from VXacThucChiTiet where MaHoaDon = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mahoadon);
      ResultSet rs = cmd.executeQuery();
      // b3: luu all du lieu vao mang ds
      while (rs.next()) {
        long MaChiTietHD = rs.getLong("MaChiTietHD");
        long MaHoaDon = rs.getLong("MaHoaDon");
        String hoten = rs.getString("hoten");
        String tensach = rs.getString("tensach");
        long SoLuongMua = rs.getLong("SoLuongMua");
        long gia = rs.getLong("gia");
        long ThanhTien = rs.getLong("ThanhTien");
        boolean damua = rs.getBoolean("damua");
        ds.add(new AdminChiTietDonHangBean(MaChiTietHD, MaHoaDon, hoten, tensach, SoLuongMua, gia,
            ThanhTien, damua));
      }
      // b4: dong ket noi
      rs.close();
      kn.cn.close();
      return ds;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }
  }

  /*
   * public ArrayList<AdminChiTietDonHangBean> getAdanhsach(long machitiet) {
   * ArrayList<AdminChiTietDonHangBean> ds = new ArrayList<AdminChiTietDonHangBean>(); try { // b1:
   * ket noi vao csdl KetNoi kn = new KetNoi(); kn.KetNoi(); // b2: lay du lieu ve String sql =
   * "select * from VXacThucChiTiet where MaChiTietHD = ?"; PreparedStatement cmd =
   * kn.cn.prepareStatement(sql); cmd.setLong(1, machitiet); ResultSet rs = cmd.executeQuery(); //
   * b3: luu all du lieu vao mang ds while (rs.next()) { long MaChiTietHD =
   * rs.getLong("MaChiTietHD"); long MaHoaDon = rs.getLong("MaHoaDon"); String hoten =
   * rs.getString("hoten"); String tensach = rs.getString("tensach"); long SoLuongMua =
   * rs.getLong("SoLuongMua"); long gia = rs.getLong("gia"); long ThanhTien =
   * rs.getLong("ThanhTien"); boolean damua = rs.getBoolean("damua"); ds.add(new
   * AdminChiTietDonHangBean(MaChiTietHD, MaHoaDon, hoten, tensach, SoLuongMua, gia, ThanhTien,
   * damua)); } // b4: dong ket noi rs.close(); kn.cn.close(); return ds; } catch (Exception e) { //
   * TODO: handle exception e.printStackTrace(); return null; } }
   */

  public int countCTHD(long mahoadon) throws Exception {
    try {
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select COUNT(damua) from ChiTietHoaDon where Damua = 0 and MaHoaDon = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mahoadon);
      ResultSet rs = cmd.executeQuery();

      while (rs.next()) {
        return (int) rs.getInt(1);
      }
      // b4: dong ket noi
      kn.cn.close();
      rs.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return 0;
  }

  public int xacnhanchitiet(int mact) {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "update VXacThucChiTiet set damua = 'true' where MaChiTietHD = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setInt(1, mact);

      return cmd.executeUpdate();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return 0;
    }
  }

}
