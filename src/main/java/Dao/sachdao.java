package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.sachbean;

public class sachdao {
  public ArrayList<sachbean> getsach() {
    ArrayList<sachbean> ds = new ArrayList<sachbean>();
    try {
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from sach";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: luu all du lieu vao mang ds
      while (rs.next()) {
        String masach = rs.getString("masach");
        String tensach = rs.getString("tensach");
        String tacgia = rs.getString("tacgia");
        int soluong = rs.getInt("soluong");
        int gia = rs.getInt("gia");
        String anh = rs.getString("anh");
        String maloai = rs.getString("maloai");
        ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
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

  public int getPageNumber() {
    try {
      // B1: ket noi csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select count(masach) as soluong from sach";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // int soluong = 0;
      // Luu all du lie vao mang
      while (rs.next()) {
        return (int) rs.getInt(1);
      }
      // Dong ket noi
      rs.close();
      kn.cn.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return 0;
  }

  public int getPageNumberSearch(String maloai) {
    try {
      // B1: ket noi csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select count(masach) as soluong from sach where maloai = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, maloai);
      ResultSet rs = cmd.executeQuery();
      // int soluong = 0;
      // Luu all du lie vao mang
      while (rs.next()) {
        return (int) rs.getInt(1);
      }
      // Dong ket noi
      rs.close();
      kn.cn.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return 0;
  }

  public int getPageNumberCategories(String key) {
    try {
      // B1: ket noi csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql =
          "select count(masach) as soluong from sach where maloai like ? or tensach like ?  or tacgia like ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, "%" + key + "%");
      cmd.setString(2, "%" + key + "%");
      cmd.setString(3, "%" + key + "%");
      ResultSet rs = cmd.executeQuery();
      // int soluong = 0;
      // Luu all du lie vao mang
      while (rs.next()) {
        return (int) rs.getInt(1);
      }
      // Dong ket noi
      rs.close();
      kn.cn.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return 0;
  }

  public ArrayList<sachbean> getPaging(int index) {
    ArrayList<sachbean> ds = new ArrayList<sachbean>();

    try {
      // B1: ket noi csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from sach order by masach OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setInt(1, (index - 1) * 12);
      ResultSet rs = cmd.executeQuery();
      // Luu all du lie vao mang
      while (rs.next()) {
        String masach = rs.getString("masach");
        String tensach = rs.getString("tensach");
        String tacgia = rs.getString("tacgia");
        int soluong = rs.getInt("soluong");
        int gia = rs.getInt("gia");
        String anh = rs.getString("anh");
        String maloai = rs.getString("maloai");
        ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
      }
      // Dong ket noi
      rs.close();
      kn.cn.close();
      return ds;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }
  }

  public ArrayList<sachbean> getPagingSearch(String key, int index) {
    ArrayList<sachbean> ds = new ArrayList<sachbean>();

    try {
      // B1: ket noi csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql =
          "select * from sach where maloai like ? or tensach like ?  or tacgia like ? order by masach OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, "%" + key + "%");
      cmd.setString(2, "%" + key + "%");
      cmd.setString(3, "%" + key + "%");

      cmd.setInt(4, (index - 1) * 12);
      ResultSet rs = cmd.executeQuery();
      // Luu all du lie vao mang
      while (rs.next()) {
        String masach = rs.getString("masach");
        String tensach = rs.getString("tensach");
        String tacgia = rs.getString("tacgia");
        int soluong = rs.getInt("soluong");
        int gia = rs.getInt("gia");
        String anh = rs.getString("anh");
        String maloai = rs.getString("maloai");
        ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
      }
      // Dong ket noi
      rs.close();
      kn.cn.close();
      return ds;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }

  }

  public ArrayList<sachbean> getPagingCategories(String key, int index) {
    ArrayList<sachbean> ds = new ArrayList<sachbean>();

    try {
      // B1: ket noi csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql =
          "select * from sach where maloai = ? order by masach OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, key);

      cmd.setInt(2, (index - 1) * 12);
      ResultSet rs = cmd.executeQuery();
      // Luu all du lie vao mang
      while (rs.next()) {
        String masach = rs.getString("masach");
        String tensach = rs.getString("tensach");
        String tacgia = rs.getString("tacgia");
        int soluong = rs.getInt("soluong");
        int gia = rs.getInt("gia");
        String anh = rs.getString("anh");
        String maloai = rs.getString("maloai");
        ds.add(new sachbean(masach, tensach, tacgia, soluong, gia, anh, maloai));
      }
      // Dong ket noi
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


