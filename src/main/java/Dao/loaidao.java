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

  public loaibean getCategory(String maloai) throws Exception {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      loaibean loai = null;
      String sql = "select * from loai where maloai = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, maloai);
      ResultSet rs = cmd.executeQuery();
      while (rs.next()) {
        String tenloai = rs.getString("tenloai");
        loai = new loaibean(maloai, tenloai);
      }
      rs.close();
      kn.cn.close();
      return loai;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return null;
  }

  public int addCategory(String maloai, String tenloai) throws Exception {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "select * from loai where maloai = ?";
      PreparedStatement check = kn.cn.prepareStatement(sql);
      check.setString(1, maloai);
      ResultSet c = check.executeQuery();
      int rs;
      if (c.next() != false) {
        return -1;
      } else if (c.next() == false) {
        String sql2 = "insert into loai (maloai, tenloai) values (?, ?)";
        PreparedStatement cmd = kn.cn.prepareStatement(sql2);
        cmd.setString(1, maloai);
        cmd.setString(2, tenloai);
        rs = cmd.executeUpdate();
      } else
        return 0;
      c.close();
      kn.cn.close();
      return rs;

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return 0;
  }

  public int deleteCategory(String maloai) throws Exception {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      int rs;
      String sql = "delete loai where maloai = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, maloai);
      rs = cmd.executeUpdate();
      kn.cn.close();
      return rs;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return 0;
  }

  public int editcategory(String maloai, String tenloai) throws Exception {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "update loai set tenloai = ? where maloai = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, tenloai);
      cmd.setString(2, maloai);
      int rs = cmd.executeUpdate();
      kn.cn.close();
      return rs;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return 0;
  }



  public int getTongLoai() {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "select count(*)from loai";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      while (rs.next()) {
        int total = rs.getInt(1);
        return total;
      }
      rs.close();
      kn.cn.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
}
