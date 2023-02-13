
package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import Bean.XacNhanBean;

public class XacNhanDao {

  public ArrayList<XacNhanBean> getdanhsach() {
    ArrayList<XacNhanBean> ds = new ArrayList<XacNhanBean>();
    try {
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      /*
       * String sql = "SELECT hoadon.MaHoaDon,\r\n" + "       hoadon.makh,\r\n" +
       * "       KhachHang.hoten,\r\n" + "       hoadon.NgayMua,\r\n" + "       hoadon.damua,\r\n" +
       * "       SUM(ChiTietHoaDon.SoLuongMua * sach.gia) AS ThanhTien\r\n" + "FROM dbo.hoadon\r\n"
       * + "INNER JOIN dbo.ChiTietHoaDon ON dbo.hoadon.MaHoaDon = dbo.ChiTietHoaDon.MaHoaDon\r\n" +
       * "INNER JOIN dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach\r\n" +
       * "INNER JOIN dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh\r\n" +
       * "GROUP BY dbo.hoadon.MaHoaDon,\r\n" + "         dbo.hoadon.makh,\r\n" +
       * "         dbo.KhachHang.hoten,\r\n" + "         dbo.hoadon.NgayMua,\r\n" +
       * "         dbo.hoadon.damua\r\n" + "ORDER BY damua ASC";
       */

      String sql = "select * from VXacNhan ORDER BY damua Asc";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: luu all du lieu vao mang ds
      while (rs.next()) {
        long MaHoaDon = rs.getLong("MaHoaDon");
        long makh = rs.getLong("makh");
        String hoten = rs.getString("hoten");
        Date NgayMua = rs.getDate("NgayMua");
        long ThanhTien = rs.getLong("ThanhTien");
        boolean damua = rs.getBoolean("damua");
        ds.add(new XacNhanBean(MaHoaDon, makh, hoten, NgayMua, ThanhTien, damua));
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

  public ArrayList<XacNhanBean> getlistbuy() {
    ArrayList<XacNhanBean> ds = new ArrayList<XacNhanBean>();
    try {
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from VXacNhan where Damua = 1";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: luu all du lieu vao mang ds
      while (rs.next()) {
        long MaHoaDon = rs.getLong("MaHoaDon");
        long makh = rs.getLong("makh");
        String hoten = rs.getString("hoten");
        Date NgayMua = rs.getDate("NgayMua");
        long ThanhTien = rs.getLong("ThanhTien");
        boolean damua = rs.getBoolean("damua");
        ds.add(new XacNhanBean(MaHoaDon, makh, hoten, NgayMua, ThanhTien, damua));
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

  public int xacnhanHD(long mahoadon) throws Exception {
    try {
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "update hoadon set damua = 'true' where MaHoaDon = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mahoadon);
      int rs = cmd.executeUpdate();

      // b4: dong ket noi
      kn.cn.close();
      return rs;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return 0;
    }
  }

  public int xacnhanCTHD(long mahoadon) throws Exception {
    try {
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "update ChiTietHoaDon set Damua = 1 where MaHoaDon = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mahoadon);
      int rs = cmd.executeUpdate();

      // b4: dong ket noi
      kn.cn.close();
      return rs;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return 0;
    }
  }

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
    return -1;
  }


}
