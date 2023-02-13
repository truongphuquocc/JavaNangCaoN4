package Dao;

import java.sql.PreparedStatement;


public class ChiTietHoaDonDao {
  public int themCTHDdao(String masach, long soluongmua, long mahd, boolean damua)
      throws Exception {
    KetNoi kn = new KetNoi();
    kn.KetNoi();
    String sql =
        " INSERT dbo.ChiTietHoaDon (MaSach, SoLuongMua, MaHoaDon, damua)  VALUES (?,?,?,?)";
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    cmd.setString(1, masach);
    cmd.setLong(2, soluongmua);
    cmd.setLong(3, mahd);
    cmd.setBoolean(4, damua);
    return cmd.executeUpdate();
  }

}
