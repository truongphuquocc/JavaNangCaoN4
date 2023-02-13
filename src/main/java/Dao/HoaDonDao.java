package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class HoaDonDao {

  public int ThemHoaDon(Long makh, Date ngaymua, boolean damua) throws SQLException {
    KetNoi kn = new KetNoi();
    int lastInsetKey = 0;
    kn.KetNoi();
    String sql = "INSERT dbo.hoadon (makh, NgayMua, damua) VALUES (?, ?, ?)";
    PreparedStatement cmd = kn.cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    cmd.setLong(1, makh);
    // java.sql.Date n =
    cmd.setDate(2, new java.sql.Date(ngaymua.getTime()));
    cmd.setBoolean(3, damua);
    cmd.executeUpdate();

    ResultSet rs = cmd.getGeneratedKeys();

    if (rs.next()) {
      lastInsetKey = rs.getInt(1);
    }

    return lastInsetKey;
  }



  public int ThemChiTietHoaDon(String masach, int soluongmua, long mahd) throws SQLException {
    KetNoi kn = new KetNoi();
    kn.KetNoi();
    String sql =
        " INSERT dbo.ChiTietHoaDon (MaSach, SoLuongMua, MaHoaDon, damua)  VALUES (?,?,?, 0)";
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    cmd.setString(1, masach);
    cmd.setInt(2, soluongmua);
    cmd.setLong(3, mahd);
    return cmd.executeUpdate();
  }

  public long GetHoaDon() throws SQLException {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      long maHDVuaTao = 0;
      String sql = "SELECT MAX(MaHoaDon) MaHoaDon FROM dbo.hoadon";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      while (rs.next()) {
        maHDVuaTao = rs.getLong("MaHoaDon");
      }
      rs.close();
      kn.cn.close();
      return maHDVuaTao;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }



}
