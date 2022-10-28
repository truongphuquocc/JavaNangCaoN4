package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.loaibean;

public class loaidao {
  public ArrayList<loaibean> getloai() {
    ArrayList<loaibean> ds = new ArrayList<loaibean>();
    try {
      // b1: kety noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from loai";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();

      while (rs.next()) {

        String maloai = rs.getString("maloai");
        String tenloai = rs.getString("tenloai");
        ds.add(new loaibean(maloai, tenloai));
      }
      rs.close();
      kn.cn.close();
      return ds;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }
  }
}
