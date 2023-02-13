package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import Bean.LichSuMuaHangBean;


public class LichSuMuaHangDao {
  KetNoi kn = new KetNoi();

  public ArrayList<LichSuMuaHangBean> getLichSuMuaHang(long makh) throws Exception {
    ArrayList<LichSuMuaHangBean> list = new ArrayList<LichSuMuaHangBean>();
    String sql = "select * from VLichSu where makh = ? Order by MaHoaDon Desc";
    kn.KetNoi();
    PreparedStatement cmd = kn.cn.prepareStatement(sql);
    cmd.setLong(1, makh);
    ResultSet rs = cmd.executeQuery();
    while (rs.next()) {
      long maHD = rs.getLong("MaHoaDon");
      long maKH = rs.getLong("makh");
      String hoten = rs.getString("hoten");
      Date NgayMua = rs.getDate("NgayMua");
      Boolean damua = rs.getBoolean("damua");
      Long ThanhT = rs.getLong("ThanhTien");
      long gia = rs.getLong("gia");
      int slm = rs.getInt("SoLuongMua");
      String ts = rs.getString("tensach");
      list.add(new LichSuMuaHangBean(maHD, maKH, hoten, NgayMua, damua, ThanhT, gia, slm, ts));
    }
    rs.close();
    kn.cn.close();
    return list;
  }
}
